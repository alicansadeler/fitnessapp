package com.alicansadeler.gymtracking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record WorkoutProgramDTO(
        @NotNull(message = "Workout name is required")
        @NotBlank(message = "Workout name cannot be blank")
        @Size(min = 2, max = 100, message = "Workout name must be between 2 and 100 characters")
        String workoutName,

        @NotNull(message = "User ID is required")
        Long userId
) {}
