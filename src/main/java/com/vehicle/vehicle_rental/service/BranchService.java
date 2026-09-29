package com.vehicle.vehicle_rental.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vehicle.vehicle_rental.entity.Branch;
import com.vehicle.vehicle_rental.repository.BranchRepository;

@Service
public class BranchService {

    private final BranchRepository branchRepository;

    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }
}