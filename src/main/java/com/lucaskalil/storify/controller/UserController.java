package com.lucaskalil.storify.controller;

import java.net.URI;
import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucaskalil.storify.Exceptions.UserAlreadyExistsException;
import com.lucaskalil.storify.controller.dto.LoginRequest;
import com.lucaskalil.storify.controller.dto.LoginResponse;
import com.lucaskalil.storify.controller.dto.RegisterRequest;
import com.lucaskalil.storify.controller.dto.RegisterResponse;
import com.lucaskalil.storify.entities.User;
import com.lucaskalil.storify.entities.enums.UserStatus;
import com.lucaskalil.storify.services.PlanService;
import com.lucaskalil.storify.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private PlanService planService;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtEncoder jwtEncoder;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
 

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest registerRequest) {
        User newUser = new User(
            registerRequest.getUsername(), 
            registerRequest.getEmail(), 
            passwordEncoder.encode(registerRequest.getPassword()), 
            planService.getDefaultPlan(), 
            0L, Instant.now(), Instant.now(),
            UserStatus.NO_PROBLEMS, 
            registerRequest.getPhone(), 
            registerRequest.getCountry());
            
        try {
            userService.save(newUser);
            URI uri = ServletUriComponentsBuilder.fromPath("/api/user/login").buildAndExpand(newUser.getId()).toUri();
            return ResponseEntity.created(uri).body(RegisterResponse.fromUser(newUser));
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        Optional<User> user = userService.findByEmail(loginRequest.getEmail());
        boolean is_valid = false;
        if(user.isPresent()) {    
            is_valid = passwordEncoder.matches(loginRequest.getPassword(), user.get().getPasswordHash());
        }
       
        if(!is_valid) {
            throw new BadCredentialsException("email or password is invalid");
        }

        Instant now = Instant.now();
        Instant expiresAt = now.plusSeconds(300);
        
        JwtClaimsSet claims = JwtClaimsSet.builder()
            .issuer("storify-java-backend")
            .subject(user.get().getId().toString())
            .issuedAt(now)
            .expiresAt(expiresAt)
            .build();
        
        String jwtToken = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new LoginResponse(jwtToken, expiresAt));
    }
}
