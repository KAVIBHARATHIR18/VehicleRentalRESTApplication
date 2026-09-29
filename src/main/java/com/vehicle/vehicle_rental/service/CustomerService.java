package com.vehicle.vehicle_rental.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vehicle.vehicle_rental.entity.Customer;
import com.vehicle.vehicle_rental.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}