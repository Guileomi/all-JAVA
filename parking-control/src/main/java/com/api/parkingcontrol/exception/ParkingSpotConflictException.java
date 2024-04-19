package com.api.parkingcontrol.exception;

public class ParkingSpotConflictException extends RuntimeException {
    public ParkingSpotConflictException(String message) {
        super(message);
    }
}
