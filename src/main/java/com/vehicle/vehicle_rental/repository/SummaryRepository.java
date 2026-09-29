package com.vehicle.vehicle_rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vehicle.vehicle_rental.entity.Summary;

public interface SummaryRepository extends JpaRepository<Summary, Integer> {
}