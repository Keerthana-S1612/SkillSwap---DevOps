package com.skillexchange.service;

import com.skillexchange.model.Skill;
import com.skillexchange.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public Skill postSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public List<Skill> getAll() {
        return skillRepository.findAll();
    }

    public List<Skill> search(String keyword) {
        return skillRepository.findBySkillNameContainingIgnoreCase(keyword);
    }

    public void delete(Long id) {
        skillRepository.deleteById(id);
    }
}
