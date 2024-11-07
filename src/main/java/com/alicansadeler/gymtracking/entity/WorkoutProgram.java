package com.alicansadeler.gymtracking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "gym_workout_program", schema = "public")
public class WorkoutProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "workout_name")
    @NotBlank(message = "Workout name cannot be blank")
    @Size(min = 3, max = 100, message = "Workout name must be between 3 and 100 characters")
    private String workoutName;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(mappedBy = "workoutProgram", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<WorkoutDay> workoutDays = new HashSet<>();

}
