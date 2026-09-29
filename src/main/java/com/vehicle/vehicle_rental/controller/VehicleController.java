package com.vehicle.vehicle_rental.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.vehicle_rental.entity.Vehicle;
import com.vehicle.vehicle_rental.service.VehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // Get all vehicles
    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    // JOIN: Vehicle with Branch
    @GetMapping("/with-branch")
    public List<Object[]> getVehiclesWithBranch() {
        return vehicleService.getVehiclesWithBranch();
    }

    // Subquery: Vehicles above average rent
    @GetMapping("/above-average-rent")
    public List<Vehicle> getVehiclesAboveAverageRent() {
        return vehicleService.getVehiclesAboveAverageRent();
    }

    // Subquery: Most expensive vehicle
    @GetMapping("/most-expensive")
    public List<Vehicle> getMostExpensiveVehicle() {
        return vehicleService.getMostExpensiveVehicle();
    }

    // ANY: Rent greater than at least one Bike
    @GetMapping("/greater-than-any-bike")
    public List<Vehicle> getVehiclesGreaterThanAnyBike() {
        return vehicleService.getVehiclesGreaterThanAnyBike();
    }

    // ALL: Rent greater than every Bike
    @GetMapping("/greater-than-all-bikes")
    public List<Vehicle> getVehiclesGreaterThanAllBikes() {
        return vehicleService.getVehiclesGreaterThanAllBikes();
    }
}