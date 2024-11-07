package com.alicansadeler.gymtracking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "gym_users", schema = "public")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    private String name;


    @Column(name = "surname")
    @NotBlank(message = "Surname cannot be blank")
    @Size(min = 3, max = 100, message = "Surname must be between 3 and 100 characters")
    private String surName;


    @Column(name = "email")
    @NotBlank(message = "Email cannot be blank")
    @Size(min = 3, max = 100, message = "Email must be between 3 and 100 characters")
    @Email
    private String email;

    @Column(name = "password")
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    private String password;


    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;


    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<WorkoutProgram> workoutPlan = new HashSet<>();


}
