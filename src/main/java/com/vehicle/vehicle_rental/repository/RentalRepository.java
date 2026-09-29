package com.vehicle.vehicle_rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vehicle.vehicle_rental.entity.Rental;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

    @Query(value = """
        SELECT
            r.rental_id,
            c.customer_name,
            v.vehicle_number,
            v.vehicle_type,
            r.start_date,
            r.return_date
        FROM rental r
        JOIN customer c
        ON r.customer_id = c.customer_id
        JOIN vehicle v
        ON r.vehicle_id = v.vehicle_id
        """, nativeQuery = true)
    List<Object[]> findRentalsWithCustomerAndVehicle();
}