package com.skillexchange.controller;

import com.skillexchange.model.SkillRequest;
import com.skillexchange.service.SkillRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/requests")
@CrossOrigin(origins = "*")
public class SkillRequestController {

    @Autowired
    private SkillRequestService skillRequestService;

    @PostMapping("/send")
    public SkillRequest sendRequest(@RequestBody SkillRequest request) {
        return skillRequestService.sendRequest(request);
    }

    @PutMapping("/{id}/status")
    public SkillRequest updateStatus(@PathVariable Long id, @RequestParam String status) {
        return skillRequestService.updateStatus(id, status);
    }

    @GetMapping("/received/{receiverId}")
    public List<SkillRequest> getReceived(@PathVariable Long receiverId) {
        return skillRequestService.getByReceiver(receiverId);
    }

    @GetMapping("/sent/{senderId}")
    public List<SkillRequest> getSent(@PathVariable Long senderId) {
        return skillRequestService.getBySender(senderId);
    }
}
