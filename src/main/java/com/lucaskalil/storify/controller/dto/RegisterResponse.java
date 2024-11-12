package com.lucaskalil.storify.controller.dto;

import java.util.UUID;

import com.lucaskalil.storify.entities.Plan;
import com.lucaskalil.storify.entities.User;

public record RegisterResponse(UUID userId, String username, String email, Plan plan, String phone, String country) {

    public static RegisterResponse fromUser(User user) {
        return new RegisterResponse(user.getId(), user.getUsername(), user.getEmail(), user.getPlan(), user.getPhone(), user.getCountry());
    }
}
