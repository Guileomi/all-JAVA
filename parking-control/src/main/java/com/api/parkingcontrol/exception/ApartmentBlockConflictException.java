package com.api.parkingcontrol.exception;

public class ApartmentBlockConflictException extends ParkingSpotConflictException {
    public ApartmentBlockConflictException(String message) {
        super(message);
    }
}
