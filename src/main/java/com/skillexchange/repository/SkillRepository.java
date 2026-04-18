package com.skillexchange.repository;

import com.skillexchange.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findBySkillNameContainingIgnoreCase(String keyword);
}
