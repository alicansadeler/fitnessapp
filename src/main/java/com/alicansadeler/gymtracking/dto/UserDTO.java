package com.alicansadeler.gymtracking.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDTO(
        @NotNull(message = "Name is required")
        @NotBlank(message = "Name cannot be blank")
        @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
        String name,

        @NotNull(message = "Surname is required")
        @NotBlank(message = "Surname cannot be blank")
        @Size(min = 2, max = 50, message = "Surname must be between 2 and 50 characters")
        String surName,

        @NotNull(message = "Email is required")
        @Email(message = "Email should be valid")
        String email,

        @NotNull(message = "Password is required")
        @Size(min = 6, message = "Password must be at least 6 characters")
        String password
) {}
