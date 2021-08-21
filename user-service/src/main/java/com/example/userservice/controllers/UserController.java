package com.example.userservice.controllers;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.model.CreateUserRequest;
import com.example.userservice.model.CreateUserResponse;
import com.example.userservice.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Environment env;
    @Autowired
    private UserService userService;

    @GetMapping("/status/check")
    public String checkStatus() {
        return "User service is working " + env.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> create(@Valid @RequestBody CreateUserRequest createUser) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDTO userDTO = modelMapper.map(createUser, UserDTO.class);
        userDTO = userService.createUser(userDTO);

        CreateUserResponse createUserResponse = modelMapper.map(userDTO, CreateUserResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUserResponse);
    }
}
