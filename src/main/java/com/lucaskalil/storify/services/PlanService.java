package com.lucaskalil.storify.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaskalil.storify.entities.Plan;
import com.lucaskalil.storify.entities.enums.PlanType;
import com.lucaskalil.storify.repositories.PlanRepository;

@Service
public class PlanService {

    @Autowired
    private PlanRepository repository;

    public Plan getDefaultPlan() {
            return repository.findByType(PlanType.DEFAULT);
    }
}
