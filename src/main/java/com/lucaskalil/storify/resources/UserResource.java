package com.lucaskalil.storify.resources;

import java.net.URI;
import java.time.Instant;
import java.util.UUID;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucaskalil.storify.Exceptions.UserAlreadyExistsException;
import com.lucaskalil.storify.Security.PasswordHasher;
import com.lucaskalil.storify.dto.LoginUserDTO;
import com.lucaskalil.storify.dto.NewUserDTO;
import com.lucaskalil.storify.entities.User;
import com.lucaskalil.storify.entities.enums.UserStatus;
import com.lucaskalil.storify.services.PlanService;
import com.lucaskalil.storify.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/user")
public class UserResource {

    @Autowired
    private PlanService planService;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordHasher passwordHasher;
 

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody NewUserDTO newUserdDto) {
        User newUser = new User(
            newUserdDto.getUsername(), newUserdDto.getEmail(), 
            passwordHasher.encode(newUserdDto.getPassword()), 
            planService.getDefaultPlan(), 0L, Instant.now(), Instant.now(),
            UserStatus.NO_PROBLEMS, newUserdDto.getPhone(), newUserdDto.getCountry());
            
        try {
            userService.save(newUser);
            URI uri = ServletUriComponentsBuilder.fromPath("/api/user/login").buildAndExpand(newUser.getId()).toUri();
            return ResponseEntity.created(uri).body(newUser);
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@Valid @RequestBody LoginUserDTO loginUserDTO) {
        User user = userService.findByEmail(loginUserDTO.getEmail());
        boolean is_valid = passwordHasher.verify(loginUserDTO.getPassword(), user.getPasswordHash());
        return ResponseEntity.ok().body(is_valid);
    }
}
