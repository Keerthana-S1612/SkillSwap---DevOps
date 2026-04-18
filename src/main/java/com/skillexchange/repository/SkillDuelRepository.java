package com.skillexchange.repository;

import com.skillexchange.model.SkillDuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillDuelRepository extends JpaRepository<SkillDuel, Long> {
    List<SkillDuel> findByStatusOrderByCreatedAtDesc(String status);
}
