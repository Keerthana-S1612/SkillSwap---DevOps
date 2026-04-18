package com.skillexchange.controller;

import com.skillexchange.model.Session;
import com.skillexchange.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sessions")
@CrossOrigin(origins = "*")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/book")
    public Session bookSession(@RequestBody Session session) {
        return sessionService.bookSession(session);
    }

    @PutMapping("/{id}/feedback")
    public Session addFeedback(@PathVariable Long id, @RequestBody Map<String, Object> payload) {
        Integer rating = (Integer) payload.get("rating");
        String feedback = (String) payload.get("feedback");
        return sessionService.addFeedback(id, rating, feedback);
    }

    @GetMapping("/teacher/{teacherId}")
    public List<Session> getByTeacher(@PathVariable Long teacherId) {
        return sessionService.getByTeacher(teacherId);
    }

    @GetMapping("/learner/{learnerId}")
    public List<Session> getByLearner(@PathVariable Long learnerId) {
        return sessionService.getByLearner(learnerId);
    }
}
