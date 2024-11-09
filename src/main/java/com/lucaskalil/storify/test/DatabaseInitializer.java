package com.lucaskalil.storify.test;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lucaskalil.storify.entities.Plan;
import com.lucaskalil.storify.entities.User;
import com.lucaskalil.storify.entities.enums.UserStatus;
import com.lucaskalil.storify.repositories.PlanRepository;
import com.lucaskalil.storify.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("Inicializando banco de dados...");

        planRepository.save(new Plan("Plano Básico", 100L));
        planRepository.save(new Plan("Plano Avançado", 500L));
        Plan primiumPlan = planRepository.save(new Plan("Plano Premium", 1000L));

        userRepository.save(new User("Lucas Kalil", "lucas.kalil2018@gmail.com", "pwd", primiumPlan, 0L, Instant.now(), Instant.now(), UserStatus.NO_PROBLEMS, "+55 (71) 99337-0283", "Brasil"));
    }
}


