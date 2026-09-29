package com.vehicle.vehicle_rental.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.vehicle_rental.entity.Payment;
import com.vehicle.vehicle_rental.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Get all payments
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // JOIN: Payment with Rental
    @GetMapping("/with-rental")
    public List<Object[]> getPaymentsWithRental() {
        return paymentService.getPaymentsWithRental();
    }
}