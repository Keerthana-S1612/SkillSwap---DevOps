package com.skillexchange.service;

import com.skillexchange.model.Student;
import com.skillexchange.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student register(Student student) {
        student.setBadge("Beginner");
        student.setRating(0.0);
        student.setAvailability("Available");
        student.setSkillCoins(50);
        student.setMentorMood("Ready to teach");
        student.setCurrentStreak(0);
        student.setSkillDna(calculateSkillDna(student.getSkillsKnown()));
        return studentRepository.save(student);
    }

    private String calculateSkillDna(String skills) {
        if (skills == null) return "Explorer";
        String lowerSkills = skills.toLowerCase();
        if (lowerSkills.contains("java") || lowerSkills.contains("python") || lowerSkills.contains("node") || lowerSkills.contains("backend") || lowerSkills.contains("sql")) {
            return "Backend Thinker";
        } else if (lowerSkills.contains("html") || lowerSkills.contains("css") || lowerSkills.contains("react") || lowerSkills.contains("angular") || lowerSkills.contains("ui")) {
            return "Frontend Creator";
        } else if (lowerSkills.contains("dsa") || lowerSkills.contains("c++") || lowerSkills.contains("algorithm")) {
            return "Problem Solver";
        } else if (lowerSkills.contains("aws") || lowerSkills.contains("docker") || lowerSkills.contains("devops") || lowerSkills.contains("linux")) {
            return "Cloud Architect";
        }
        return "Versatile Learner";
    }

    public Student login(String email, String password) {
        Optional<Student> studentOpt = studentRepository.findByEmail(email);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            if (student.getPassword().equals(password)) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateAvailability(Long id, String availability) {
        Student student = getById(id);
        if (student != null) {
            student.setAvailability(availability);
            return studentRepository.save(student);
        }
        return null;
    }

    public Student updateRating(Long id, Double rating) {
        Student student = getById(id);
        if (student != null) {
            student.setRating(rating);
            return studentRepository.save(student);
        }
        return null;
    }

    public Student updateBadge(Long id, int skillsPosted, int sessionsCompleted) {
        Student student = getById(id);
        if (student != null) {
            if (sessionsCompleted >= 5) {
                student.setBadge("Top Mentor");
            } else if (skillsPosted >= 3) {
                student.setBadge("Active Learner");
            } else {
                student.setBadge("Beginner");
            }
            return studentRepository.save(student);
        }
        return null;
    }

    public Student updateMood(Long id, String mood) {
        Student student = getById(id);
        if (student != null) {
            student.setMentorMood(mood);
            return studentRepository.save(student);
        }
        return null;
    }

    public void transferCoins(Long teacherId, Long learnerId, int amount) {
        Student teacher = getById(teacherId);
        Student learner = getById(learnerId);
        if (teacher != null && learner != null) {
            teacher.setSkillCoins(teacher.getSkillCoins() + amount);
            learner.setSkillCoins(Math.max(0, learner.getSkillCoins() - amount));
            studentRepository.save(teacher);
            studentRepository.save(learner);
        }
    }
}
