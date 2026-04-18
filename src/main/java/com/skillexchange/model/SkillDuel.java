package com.skillexchange.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "skill_duels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillDuel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "challenger_id", nullable = false)
    private Student challenger;

    @ManyToOne
    @JoinColumn(name = "challenged_id", nullable = false)
    private Student challenged;

    private String topic;
    
    private String status; // PENDING, ACCEPTED, COMPLETED

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Student winner;
    
    private LocalDateTime createdAt;
}
