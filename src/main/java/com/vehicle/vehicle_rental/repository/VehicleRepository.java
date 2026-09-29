package com.vehicle.vehicle_rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vehicle.vehicle_rental.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    // JOIN: Vehicle with Branch
    @Query(value = """
        SELECT
            v.vehicle_id,
            v.vehicle_number,
            v.vehicle_type,
            v.rent_per_day,
            b.branch_name,
            b.city
        FROM vehicle v
        JOIN branch b
        ON v.branch_id = b.branch_id
        """, nativeQuery = true)
    List<Object[]> findVehiclesWithBranch();


    // Subquery: Vehicles above average rent
    @Query(value = """
        SELECT *
        FROM vehicle
        WHERE rent_per_day > (
            SELECT AVG(rent_per_day)
            FROM vehicle
        )
        """, nativeQuery = true)
    List<Vehicle> findVehiclesAboveAverageRent();


    // Subquery: Most expensive vehicle
    @Query(value = """
        SELECT *
        FROM vehicle
        WHERE rent_per_day = (
            SELECT MAX(rent_per_day)
            FROM vehicle
        )
        """, nativeQuery = true)
    List<Vehicle> findMostExpensiveVehicle();


    // ANY: Rent greater than at least one Bike
    @Query(value = """
        SELECT *
        FROM vehicle
        WHERE rent_per_day > ANY (
            SELECT rent_per_day
            FROM vehicle
            WHERE vehicle_type = 'Bike'
        )
        """, nativeQuery = true)
    List<Vehicle> findVehiclesGreaterThanAnyBike();


    // ALL: Rent greater than every Bike
    @Query(value = """
        SELECT *
        FROM vehicle
        WHERE rent_per_day > ALL (
            SELECT rent_per_day
            FROM vehicle
            WHERE vehicle_type = 'Bike'
        )
        """, nativeQuery = true)
    List<Vehicle> findVehiclesGreaterThanAllBikes();
}