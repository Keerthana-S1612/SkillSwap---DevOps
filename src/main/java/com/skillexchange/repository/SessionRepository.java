package com.skillexchange.repository;

import com.skillexchange.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findByTeacher_StudentId(Long teacherId);
    List<Session> findByLearner_StudentId(Long learnerId);
}
