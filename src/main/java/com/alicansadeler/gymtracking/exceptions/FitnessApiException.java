package com.alicansadeler.gymtracking.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FitnessApiException extends RuntimeException{

    private HttpStatus httpStatus;

    public FitnessApiException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}

