package com.skillexchange.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "skill_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private Student sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private Student receiver;

    private String skillName;
    
    private String status; // PENDING, ACCEPTED, REJECTED
}
