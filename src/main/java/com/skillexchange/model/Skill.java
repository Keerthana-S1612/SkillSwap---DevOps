package com.skillexchange.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "skills")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;

    private String skillName;
    
    @Column(length = 1000)
    private String description;
    
    private String availableTime;
    
    private String skillLevel;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}
