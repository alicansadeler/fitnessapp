package com.alicansadeler.gymtracking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "gym_exercise", schema = "public")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "exercise_name")
    @NotBlank(message = "Exercise name cannot be blank")
    @Size(max = 100, message = "Exercise name cannot be more than 100 characters")
    private String exerciseName;

    @Column(name = "sets")
    @Min(value = 1, message = "Sets must be at least 1")
    private int sets;

    @Column(name = "repetitions")
    @Min(value = 1, message = "Repetitions must be at least 1")
    private int repetitions;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "workout_day_id")
    private WorkoutDay workoutDay;
}

