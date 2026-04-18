package com.skillexchange.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "emergency_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "requester_id", nullable = false)
    private Student requester;

    private String topic;

    private String details;

    private LocalDateTime requestedAt;

    private String status; // PENDING, ACCEPTED, RESOLVED
    
    @ManyToOne
    @JoinColumn(name = "helper_id")
    private Student helper;
}
