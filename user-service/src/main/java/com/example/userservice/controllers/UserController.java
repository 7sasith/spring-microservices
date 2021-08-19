package com.example.userservice.controllers;

import com.example.userservice.model.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Environment env;

    @GetMapping("/status/check")
    public String checkStatus() {
        return "User service is working " + env.getProperty("local.server.port");
    }

    @PostMapping
    public String create(@Valid @RequestBody CreateUserRequest createUser) {
        return "sberwgerghwr";
    }
}
