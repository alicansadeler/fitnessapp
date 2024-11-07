package com.alicansadeler.gymtracking.dto;

public record FitnessApiResponse<T>(
        boolean success,
        String message,
        T data
) {}
