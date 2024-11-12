package com.lucaskalil.storify.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaskalil.storify.entities.Plan;
import com.lucaskalil.storify.entities.enums.PlanType;


public interface PlanRepository extends JpaRepository<Plan, UUID> {
    public Plan findByType(PlanType type);
}
