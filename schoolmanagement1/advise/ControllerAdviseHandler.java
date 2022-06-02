package com.example.schoolmanagement1.advise;


import com.example.schoolmanagement1.DTO.API;
import com.example.schoolmanagement1.exceptions.InvalidClassroomIdException;
import com.example.schoolmanagement1.exceptions.InvalidStudentIdException;
import com.example.schoolmanagement1.exceptions.InvalidTeacherIdException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@RestControllerAdvice
public class ControllerAdviseHandler {

    Logger logger= LoggerFactory.getLogger(ControllerAdviseHandler.class);

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<API> handleMethodArgument(MethodArgumentNotValidException methodArgumentNotValidException){
        String message=methodArgumentNotValidException.getFieldError().getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(message,400));
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<API> handleDataIntegrity(DataIntegrityViolationException dataIntegrityViolationException){
        String message=dataIntegrityViolationException.getRootCause().getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(message,400));
    }



    @ExceptionHandler(value = InvalidStudentIdException.class)
    public ResponseEntity<API> handleDataIntegrity(InvalidStudentIdException invalidIDException){
        String message=invalidIDException.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(message,400));
    }

    @ExceptionHandler(value = InvalidTeacherIdException.class)
    public ResponseEntity<API> handleDataIntegrity(InvalidTeacherIdException invalidIDException){
        String message=invalidIDException.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(message,400));
    }
    @ExceptionHandler(value = InvalidClassroomIdException.class)
    public ResponseEntity<API> handleDataIntegrity(InvalidClassroomIdException invalidIDException){
        String message=invalidIDException.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(message,400));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<API> handleException(Exception exception){
        System.out.println(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new API("SERVER ERROR !",500));
    }
}
