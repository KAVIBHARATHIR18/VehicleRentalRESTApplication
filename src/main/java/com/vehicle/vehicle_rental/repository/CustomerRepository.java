package com.vehicle.vehicle_rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicle.vehicle_rental.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}