package com.vehicle.vehicle_rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vehicle.vehicle_rental.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    // JOIN: Payment with Rental
    @Query(value = """
        SELECT
            p.payment_id,
            r.rental_id,
            p.amount,
            p.payment_date,
            r.customer_id,
            r.vehicle_id
        FROM payment p
        JOIN rental r
        ON p.rental_id = r.rental_id
        """, nativeQuery = true)
    List<Object[]> findPaymentsWithRental();
}