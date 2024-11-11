package com.lucaskalil.storify.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaskalil.storify.Exceptions.UserAlreadyExistsException;
import com.lucaskalil.storify.entities.User;
import com.lucaskalil.storify.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public User save(User newUser) {
        if (repository.existsByEmail(newUser.getEmail())) {
            throw new UserAlreadyExistsException("User with email " + newUser.getEmail() + " already exists.");
        }
        return repository.save(newUser);
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
