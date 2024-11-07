package com.alicansadeler.gymtracking.service;

import com.alicansadeler.gymtracking.dto.WorkoutProgramDTO;
import com.alicansadeler.gymtracking.entity.WorkoutProgram;
import jakarta.validation.Valid;

public interface WorkoutProgramService {
    WorkoutProgram saveWorkoutProgram(@Valid WorkoutProgramDTO workoutProgramDTO);
    WorkoutProgram updateWorkoutProgram(Long id, @Valid WorkoutProgramDTO workoutProgramDTO);
    WorkoutProgram getWorkoutProgramById(Long id);
    void deleteWorkoutProgram(Long id);
}
