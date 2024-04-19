package com.api.parkingcontrol.exception;

public class LicensePlateCarConflictException extends ParkingSpotConflictException {
    public LicensePlateCarConflictException(String message) {
        super(message);
    }
}
