package com.skillexchange.controller;

import com.skillexchange.model.Skill;
import com.skillexchange.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = "*")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping("/post")
    public Skill postSkill(@RequestBody Skill skill) {
        return skillService.postSkill(skill);
    }

    @GetMapping("/all")
    public List<Skill> getAll() {
        return skillService.getAll();
    }

    @GetMapping("/search")
    public List<Skill> search(@RequestParam String keyword) {
        return skillService.search(keyword);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        skillService.delete(id);
    }
}
