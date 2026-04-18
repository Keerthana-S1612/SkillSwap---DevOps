package com.skillexchange.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "sessions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Student teacher;

    @ManyToOne
    @JoinColumn(name = "learner_id", nullable = false)
    private Student learner;

    private LocalDate date;
    
    private LocalTime time;
    
    private String mode; // Online, Offline
    
    private String meetingLink;
    
    private String status; // SCHEDULED, COMPLETED, CANCELLED
    
    private Integer rating;
    
    @Column(length = 1000)
    private String feedback;

    // SkillSwap
    private Integer coinTransaction; // Number of coins exchanged
}
