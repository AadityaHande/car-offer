package com.carwala.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
@RestControllerAdvice

public class GlobalException {

        @ExceptionHandler (ClassNotFoundException.class)
        public String handleClassNotFoundException(ClassNotFoundException ex) {
            return "Class not found: " + ex.getMessage();
        }

        @ExceptionHandler (CarNotFoundException.class)
        public ResponseEntity<String> handleCarNotFoundException(CarNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
}
