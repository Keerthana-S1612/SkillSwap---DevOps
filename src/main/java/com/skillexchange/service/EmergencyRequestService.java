package com.skillexchange.service;

import com.skillexchange.model.EmergencyRequest;
import com.skillexchange.repository.EmergencyRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmergencyRequestService {

    @Autowired
    private EmergencyRequestRepository repository;

    public EmergencyRequest createRequest(EmergencyRequest request) {
        request.setRequestedAt(LocalDateTime.now());
        request.setStatus("PENDING");
        return repository.save(request);
    }

    public List<EmergencyRequest> getPendingRequests() {
        return repository.findByStatusOrderByRequestedAtDesc("PENDING");
    }

    public EmergencyRequest acceptRequest(Long id, com.skillexchange.model.Student helper) {
        EmergencyRequest request = repository.findById(id).orElse(null);
        if (request != null && request.getStatus().equals("PENDING")) {
            request.setHelper(helper);
            request.setStatus("ACCEPTED");
            return repository.save(request);
        }
        return null;
    }
}
