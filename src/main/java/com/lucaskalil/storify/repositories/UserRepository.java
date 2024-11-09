package com.lucaskalil.storify.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaskalil.storify.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
