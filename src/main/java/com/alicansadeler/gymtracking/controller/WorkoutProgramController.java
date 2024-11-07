package com.alicansadeler.gymtracking.controller;

import com.alicansadeler.gymtracking.dto.FitnessApiResponse;
import com.alicansadeler.gymtracking.dto.WorkoutProgramDTO;
import com.alicansadeler.gymtracking.entity.WorkoutProgram;
import com.alicansadeler.gymtracking.service.WorkoutProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workout-programs")
public class WorkoutProgramController  {
    private final WorkoutProgramService workoutProgramService;

    @Autowired
    public WorkoutProgramController(WorkoutProgramService workoutProgramService) {
        this.workoutProgramService = workoutProgramService;
    }

    @PostMapping
    public FitnessApiResponse<WorkoutProgram> createWorkoutProgram(@RequestBody WorkoutProgramDTO workoutProgramDTO) {
        WorkoutProgram workoutProgram = workoutProgramService.saveWorkoutProgram(workoutProgramDTO);
        return new FitnessApiResponse<>(true, "Workout Program created successfully", workoutProgram);
    }

    @PutMapping("/{id}")
    public FitnessApiResponse<WorkoutProgram> updateWorkoutProgram(@PathVariable Long id, @RequestBody WorkoutProgramDTO workoutProgramDTO) {
        WorkoutProgram workoutProgram = workoutProgramService.updateWorkoutProgram(id, workoutProgramDTO);
        return new FitnessApiResponse<>(true, "Workout Program updated successfully", workoutProgram);
    }

    @GetMapping("/{id}")
    public FitnessApiResponse<WorkoutProgram> getWorkoutProgram(@PathVariable Long id) {
        WorkoutProgram workoutProgram = workoutProgramService.getWorkoutProgramById(id);
        return new FitnessApiResponse<>(true, "Workout Program retrieved successfully", workoutProgram);
    }

    @DeleteMapping("/{id}")
    public FitnessApiResponse<Void> deleteWorkoutProgram(@PathVariable Long id) {
        workoutProgramService.deleteWorkoutProgram(id);
        return new FitnessApiResponse<>(true, "Workout Program deleted successfully", null);
    }
}
