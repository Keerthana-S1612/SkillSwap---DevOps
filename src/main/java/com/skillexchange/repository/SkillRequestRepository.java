package com.skillexchange.repository;

import com.skillexchange.model.SkillRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRequestRepository extends JpaRepository<SkillRequest, Long> {
    List<SkillRequest> findByReceiver_StudentId(Long receiverId);
    List<SkillRequest> findBySender_StudentId(Long senderId);
}
