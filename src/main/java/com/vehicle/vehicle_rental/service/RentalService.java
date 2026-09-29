package com.vehicle.vehicle_rental.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vehicle.vehicle_rental.entity.Rental;
import com.vehicle.vehicle_rental.repository.RentalRepository;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    // Get all rentals
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    // JOIN: Rental with Customer and Vehicle
    public List<Object[]> getRentalsWithCustomerAndVehicle() {
        return rentalRepository.findRentalsWithCustomerAndVehicle();
    }
}