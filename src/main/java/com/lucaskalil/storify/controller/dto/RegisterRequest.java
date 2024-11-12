package com.lucaskalil.storify.controller.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterRequest {

    @NotBlank(message = "Username cannot be empty.")
    @Size(min = 2, max = 255, message = "Username must be between 2 and 255 characters.")
    private String username;

    @NotBlank(message = "Password cannot be empty.")
    @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters.")
    private String password;

    @NotBlank(message = "Email cannot be empty.")
    @Size(min = 8, max = 255, message = "Email must be between 8 and 255 characters.")
    @Email(message = "Email should be valid.")
    private String email;

    @Nullable
    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Phone number must follow the format: (XX) XXXX-XXXX or (XX) XXXXX-XXXX.")
    private String phone;
    
    @Nullable
    @Size(min = 2, max = 64, message = "Country name must be between 2 and 64 characters.")
    private String country;

    public RegisterRequest() {}

    public RegisterRequest(@NotBlank(message = "") @Size(min = 2, max = 255) String username,
            @NotBlank(message = "") @Size(min = 8, max = 255) String password,
            @NotBlank(message = "") @Size(min = 8, max = 255) String email,
            @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}") String phone, @Size(min = 2, max = 64) String country) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.country = country;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    
}
