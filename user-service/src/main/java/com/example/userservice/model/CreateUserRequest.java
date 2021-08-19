package com.example.userservice.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequest {

    @NotNull(message = "First name cannot be null")
    @Size(min = 2, message = "First name must have min 2 chars")
    private String firstName;

    @NotNull(message = "Second name cannot be null")
    @Size(min = 2, message = "Second name must have min 2 chars")
    private String lastName;

    @NotNull(message = "Password name cannot be null")
    @Email
    private String email;

    @NotNull(message = "Password name cannot be null")
    @Size(min = 8, max = 16, message = "Password should have limited chars")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
