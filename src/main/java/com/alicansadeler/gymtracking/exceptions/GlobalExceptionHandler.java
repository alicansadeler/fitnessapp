package com.alicansadeler.gymtracking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FitnessApiException.class)
    public ResponseEntity<FitnessApiExceptionResponse> fitnessApiExceptionResponseResponse(FitnessApiException fitnessApiException) {
        FitnessApiExceptionResponse fitnessApiExceptionResponse = new FitnessApiExceptionResponse(
                fitnessApiException.getMessage()
        );
        return new ResponseEntity<>(fitnessApiExceptionResponse, fitnessApiException.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<FitnessApiExceptionResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errorDetails = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorDetails.put(fieldName, errorMessage);
        });

        FitnessApiExceptionResponse response = new FitnessApiExceptionResponse(
                "Validation failed: " + errorDetails.toString()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<FitnessApiExceptionResponse> globalHandler(Exception e) {
        FitnessApiExceptionResponse fitnessApiExceptionResponse = new FitnessApiExceptionResponse(
                e.getMessage()
        );

        return new ResponseEntity<>(fitnessApiExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
