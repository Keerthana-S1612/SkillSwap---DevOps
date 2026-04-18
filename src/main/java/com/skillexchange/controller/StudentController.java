package com.skillexchange.controller;

import com.skillexchange.model.Student;
import com.skillexchange.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public Student register(@RequestBody Student student) {
        return studentService.register(student);
    }

    @PostMapping("/login")
    public Student login(@RequestBody Map<String, String> credentials) {
        return studentService.login(credentials.get("email"), credentials.get("password"));
    }

    @GetMapping("/all")
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @PutMapping("/{id}/availability")
    public Student updateAvailability(@PathVariable Long id, @RequestBody Map<String, String> payload) {
        return studentService.updateAvailability(id, payload.get("availability"));
    }

    @PutMapping("/{id}/rating")
    public Student updateRating(@PathVariable Long id, @RequestBody Map<String, Double> payload) {
        return studentService.updateRating(id, payload.get("rating"));
    }

    @PutMapping("/{id}/badge")
    public Student updateBadge(@PathVariable Long id, @RequestBody Map<String, Integer> payload) {
        return studentService.updateBadge(id, payload.get("skillsPosted"), payload.get("sessionsCompleted"));
    }
}
