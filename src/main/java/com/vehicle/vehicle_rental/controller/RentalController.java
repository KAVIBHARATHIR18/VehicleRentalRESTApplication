package com.vehicle.vehicle_rental.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.vehicle_rental.entity.Rental;
import com.vehicle.vehicle_rental.service.RentalService;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    // Get all rentals
    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    // JOIN: Rental with Customer and Vehicle
    @GetMapping("/with-customer-vehicle")
    public List<Object[]> getRentalsWithCustomerAndVehicle() {
        return rentalService.getRentalsWithCustomerAndVehicle();
    }
}