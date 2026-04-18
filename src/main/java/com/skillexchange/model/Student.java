package com.skillexchange.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String name;
    
    @Column(unique = true)
    private String email;
    
    private String password;
    
    private String department;
    
    private String year;
    
    private String skillsKnown;
    
    private String skillsWanted;
    
    private String badge;
    
    private Double rating;
    
    private String availability;

    // SkillSwap Features
    @Column(nullable = false, columnDefinition = "int default 50")
    private Integer skillCoins = 50;

    private String mentorMood = "Ready to teach"; // "Ready to teach", "Need break", "Busy"

    private Integer currentStreak = 0;

    private LocalDate lastSessionDate;

    private String skillDna; // "Backend Thinker", "Frontend Creator", "Problem Solver"

    private Boolean isAnonymousModeEnabled = false;
}
