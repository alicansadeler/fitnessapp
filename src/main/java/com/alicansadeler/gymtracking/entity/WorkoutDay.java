package com.alicansadeler.gymtracking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "gym_workout_day", schema = "public")
public class WorkoutDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "workout_program_id")
    private WorkoutProgram workoutProgram;

    @OneToMany(mappedBy = "workoutDay", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Exercise> exercises = new HashSet<>();
}
