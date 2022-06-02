package com.example.schoolmanagement1.exceptions;

public class InvalidStudentIdException extends RuntimeException {

    public InvalidStudentIdException(String message) {
        super(message);
    }
}