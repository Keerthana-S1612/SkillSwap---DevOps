package com.skillexchange.service;

import com.skillexchange.model.SkillRequest;
import com.skillexchange.repository.SkillRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillRequestService {

    @Autowired
    private SkillRequestRepository skillRequestRepository;

    public SkillRequest sendRequest(SkillRequest request) {
        request.setStatus("PENDING");
        return skillRequestRepository.save(request);
    }

    public SkillRequest updateStatus(Long id, String status) {
        SkillRequest request = skillRequestRepository.findById(id).orElse(null);
        if (request != null) {
            request.setStatus(status);
            return skillRequestRepository.save(request);
        }
        return null;
    }

    public List<SkillRequest> getByReceiver(Long receiverId) {
        return skillRequestRepository.findByReceiver_StudentId(receiverId);
    }

    public List<SkillRequest> getBySender(Long senderId) {
        return skillRequestRepository.findBySender_StudentId(senderId);
    }
}
