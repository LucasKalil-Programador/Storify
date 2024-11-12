package com.lucaskalil.storify.controller.dto;

import java.time.Instant;

public record LoginResponse(String jwt, Instant expirationTime) {}
