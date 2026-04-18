package com.skillexchange.controller;

import com.skillexchange.model.EmergencyRequest;
import com.skillexchange.model.Student;
import com.skillexchange.service.EmergencyRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emergency")
@CrossOrigin(origins = "*")
public class EmergencyRequestController {

    @Autowired
    private EmergencyRequestService service;

    @PostMapping("/create")
    public EmergencyRequest create(@RequestBody EmergencyRequest request) {
        return service.createRequest(request);
    }

    @GetMapping("/pending")
    public List<EmergencyRequest> getPending() {
        return service.getPendingRequests();
    }

    @PutMapping("/{id}/accept")
    public EmergencyRequest accept(@PathVariable Long id, @RequestBody Student helper) {
        return service.acceptRequest(id, helper);
    }
}
