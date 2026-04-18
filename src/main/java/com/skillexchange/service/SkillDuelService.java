package com.skillexchange.service;

import com.skillexchange.model.SkillDuel;
import com.skillexchange.repository.SkillDuelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SkillDuelService {

    @Autowired
    private SkillDuelRepository repository;

    public SkillDuel createDuel(SkillDuel duel) {
        duel.setCreatedAt(LocalDateTime.now());
        duel.setStatus("PENDING");
        return repository.save(duel);
    }

    public List<SkillDuel> getPendingDuels() {
        return repository.findByStatusOrderByCreatedAtDesc("PENDING");
    }

    public SkillDuel acceptDuel(Long id) {
        SkillDuel duel = repository.findById(id).orElse(null);
        if (duel != null && duel.getStatus().equals("PENDING")) {
            duel.setStatus("ACCEPTED");
            return repository.save(duel);
        }
        return null;
    }
}
