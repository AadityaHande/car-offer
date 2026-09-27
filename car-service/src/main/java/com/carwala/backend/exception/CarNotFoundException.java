package com.carwala.backend.exception;

public class CarNotFoundException extends RuntimeException {
    
    public CarNotFoundException(String message) {
        super("Car not found: " + message);
    }
}
