package com.vehicle.vehicle_rental.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vehicle.vehicle_rental.entity.Vehicle;
import com.vehicle.vehicle_rental.repository.VehicleRepository;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    // Get all vehicles
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    // JOIN: Vehicle with Branch
    public List<Object[]> getVehiclesWithBranch() {
        return vehicleRepository.findVehiclesWithBranch();
    }

    // Subquery: Vehicles above average rent
    public List<Vehicle> getVehiclesAboveAverageRent() {
        return vehicleRepository.findVehiclesAboveAverageRent();
    }

    // Subquery: Most expensive vehicle
    public List<Vehicle> getMostExpensiveVehicle() {
        return vehicleRepository.findMostExpensiveVehicle();
    }

    // ANY: Rent greater than at least one Bike
    public List<Vehicle> getVehiclesGreaterThanAnyBike() {
        return vehicleRepository.findVehiclesGreaterThanAnyBike();
    }

    // ALL: Rent greater than every Bike
    public List<Vehicle> getVehiclesGreaterThanAllBikes() {
        return vehicleRepository.findVehiclesGreaterThanAllBikes();
    }
}