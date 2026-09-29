package com.vehicle.vehicle_rental.service;

import org.springframework.stereotype.Service;
import com.vehicle.vehicle_rental.entity.Summary;
import com.vehicle.vehicle_rental.repository.SummaryRepository;

@Service
public class SummaryService {

    private final SummaryRepository summaryRepository;

    public SummaryService(SummaryRepository summaryRepository) {
        this.summaryRepository = summaryRepository;
    }

    public Summary getSummary() {
        return summaryRepository.findById(1).orElse(null);
    }
}