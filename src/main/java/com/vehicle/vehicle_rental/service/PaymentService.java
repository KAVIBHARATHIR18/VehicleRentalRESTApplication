package com.vehicle.vehicle_rental.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vehicle.vehicle_rental.entity.Payment;
import com.vehicle.vehicle_rental.repository.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // Get all payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // JOIN: Payment with Rental
    public List<Object[]> getPaymentsWithRental() {
        return paymentRepository.findPaymentsWithRental();
    }
}