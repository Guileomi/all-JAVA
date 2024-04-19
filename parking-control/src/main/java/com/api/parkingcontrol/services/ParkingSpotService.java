package com.api.parkingcontrol.services;

import com.api.parkingcontrol.dtos.ParkingSpotDTO;
import com.api.parkingcontrol.exception.ApartmentBlockConflictException;
import com.api.parkingcontrol.exception.LicensePlateCarConflictException;
import com.api.parkingcontrol.exception.ParkingSpotNumberConflictException;
import com.api.parkingcontrol.models.ParkingSpot;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public ParkingSpot save(ParkingSpot parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
    }

    public Page<ParkingSpot> findAll(Pageable pageable){
        return parkingSpotRepository.findAll(pageable);
    }

    public Optional<ParkingSpot> findById(UUID id) {
        return parkingSpotRepository.findById(id);
    }

    @Transactional
    public void delete(ParkingSpot parkingSpot) {
        parkingSpotRepository.delete(parkingSpot);
    }

    public void validateParkingSpot(ParkingSpotDTO parkingSpotDTO) {
        if (existsByLicensePlateCar(parkingSpotDTO.getLicensePlateCar())) {
            throw new LicensePlateCarConflictException("Conflito: Esta placa de carro já está registrada no sistema");
        }
        if (existsByParkingSpotNumber(parkingSpotDTO.getParkingSpotNumber())) {
            throw new ParkingSpotNumberConflictException("Conflito: Este número de vaga já está registrado no sistema");
        }
        if (existsByApartmentAndBlock(parkingSpotDTO.getApartment(), parkingSpotDTO.getBlock())) {
            throw new ApartmentBlockConflictException("Conflito: Este apartamento/bloco já está registrado no sistema");
        }
    }
}
