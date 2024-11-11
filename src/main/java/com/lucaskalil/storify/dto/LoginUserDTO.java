package com.lucaskalil.storify.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginUserDTO {

    @NotBlank(message = "Password cannot be empty.")
    @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters.")
    private String password;

    @NotBlank(message = "Email cannot be empty.")
    @Size(min = 8, max = 255, message = "Email must be between 8 and 255 characters.")
    @Email(message = "Email should be valid.")
    private String email;

    

    public LoginUserDTO() {}

    public LoginUserDTO(
            @NotBlank(message = "Password cannot be empty.") @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters.") String password,
            @NotBlank(message = "Email cannot be empty.") @Size(min = 8, max = 255, message = "Email must be between 8 and 255 characters.") @Email(message = "Email should be valid.") String email) {
        this.password = password;
        this.email = email;
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

    
}
