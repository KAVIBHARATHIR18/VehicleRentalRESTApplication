package com.vehicle.vehicle_rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vehicle.vehicle_rental.entity.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer> {

}