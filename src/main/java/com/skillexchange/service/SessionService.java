package com.skillexchange.service;

import com.skillexchange.model.Session;
import com.skillexchange.model.Student;
import com.skillexchange.repository.SessionRepository;
import com.skillexchange.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    public Session bookSession(Session session) {
        session.setStatus("SCHEDULED");
        // Instant Mini Room Feature
        session.setMeetingLink("https://meet.jit.si/SkillSwap-" + UUID.randomUUID().toString().substring(0, 8));
        return sessionRepository.save(session);
    }

    public Session addFeedback(Long id, Integer rating, String feedback) {
        Session session = sessionRepository.findById(id).orElse(null);
        if (session != null && !session.getStatus().equals("COMPLETED")) {
            session.setStatus("COMPLETED");
            session.setRating(rating);
            session.setFeedback(feedback);
            
            // Skill Barter Wallet Logic: e.g., 10 coins
            int coinsToTransfer = 10;
            session.setCoinTransaction(coinsToTransfer);
            studentService.transferCoins(session.getTeacher().getStudentId(), session.getLearner().getStudentId(), coinsToTransfer);

            // Learning Streak Feature
            updateStreak(session.getTeacher());
            updateStreak(session.getLearner());

            return sessionRepository.save(session);
        }
        return null;
    }

    private void updateStreak(Student student) {
        if (student == null) return;
        LocalDate today = LocalDate.now();
        if (student.getLastSessionDate() == null) {
            student.setCurrentStreak(1);
        } else if (student.getLastSessionDate().equals(today.minusDays(1))) {
            student.setCurrentStreak(student.getCurrentStreak() + 1);
        } else if (!student.getLastSessionDate().equals(today)) {
            student.setCurrentStreak(1); // Streak broken
        }
        student.setLastSessionDate(today);
        studentRepository.save(student);
    }

    public List<Session> getByTeacher(Long teacherId) {
        return sessionRepository.findByTeacher_StudentId(teacherId);
    }

    public List<Session> getByLearner(Long learnerId) {
        return sessionRepository.findByLearner_StudentId(learnerId);
    }
}
