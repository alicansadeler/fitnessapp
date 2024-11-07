package com.alicansadeler.gymtracking.service;

import com.alicansadeler.gymtracking.dto.WorkoutProgramDTO;
import com.alicansadeler.gymtracking.entity.Users;
import com.alicansadeler.gymtracking.entity.WorkoutProgram;
import com.alicansadeler.gymtracking.exceptions.FitnessApiException;
import com.alicansadeler.gymtracking.repository.UserRepository;
import com.alicansadeler.gymtracking.repository.WorkoutProgramRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class WorkoutProgramServiceImpl implements WorkoutProgramService{
    private final WorkoutProgramRepository workoutProgramRepository;
    private final UserRepository userRepository;

    @Autowired
    public WorkoutProgramServiceImpl(WorkoutProgramRepository workoutProgramRepository, UserRepository userRepository) {
        this.workoutProgramRepository = workoutProgramRepository;
        this.userRepository = userRepository;
    }

    @Override
    public WorkoutProgram saveWorkoutProgram(@Valid WorkoutProgramDTO workoutProgramDTO) {
        Users user = userRepository.findById(workoutProgramDTO.userId()).orElseThrow(() -> new FitnessApiException("User not found" , HttpStatus.NOT_FOUND));
        WorkoutProgram workoutProgram = new WorkoutProgram();
        workoutProgram.setWorkoutName(workoutProgramDTO.workoutName());
        workoutProgram.setUser(user);
        return workoutProgramRepository.save(workoutProgram);
    }

    @Override
    public WorkoutProgram updateWorkoutProgram(Long id, @Valid WorkoutProgramDTO workoutProgramDTO) {
        WorkoutProgram existingWorkoutProgram = workoutProgramRepository.findById(id).orElseThrow(() -> new FitnessApiException("Workout Program not found", HttpStatus.NOT_FOUND));
        Users user = userRepository.findById(workoutProgramDTO.userId()).orElseThrow(() -> new FitnessApiException("User not found", HttpStatus.NOT_FOUND));
        existingWorkoutProgram.setWorkoutName(workoutProgramDTO.workoutName());
        existingWorkoutProgram.setUser(user);
        return workoutProgramRepository.save(existingWorkoutProgram);
    }

    @Override
    public WorkoutProgram getWorkoutProgramById(Long id) {
        return workoutProgramRepository.findById(id).orElseThrow(() -> new FitnessApiException("Workout Program not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteWorkoutProgram(Long id) {
        workoutProgramRepository.deleteById(id);
    }
}
