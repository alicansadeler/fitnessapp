package com.alicansadeler.gymtracking.repository;

import com.alicansadeler.gymtracking.entity.WorkoutProgram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutProgramRepository extends JpaRepository<WorkoutProgram, Long> {
}
