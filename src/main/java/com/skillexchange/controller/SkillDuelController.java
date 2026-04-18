package com.skillexchange.controller;

import com.skillexchange.model.SkillDuel;
import com.skillexchange.service.SkillDuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/duels")
@CrossOrigin(origins = "*")
public class SkillDuelController {

    @Autowired
    private SkillDuelService service;

    @PostMapping("/create")
    public SkillDuel create(@RequestBody SkillDuel duel) {
        return service.createDuel(duel);
    }

    @GetMapping("/pending")
    public List<SkillDuel> getPending() {
        return service.getPendingDuels();
    }

    @PutMapping("/{id}/accept")
    public SkillDuel accept(@PathVariable Long id) {
        return service.acceptDuel(id);
    }
}
