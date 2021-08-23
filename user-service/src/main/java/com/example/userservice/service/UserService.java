package com.example.userservice.service;

import com.example.userservice.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  extends UserDetailsService {

    UserDTO createUser(UserDTO useDTO);
    UserDTO getUserDetails(String email);
}
