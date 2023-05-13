package com.store.backend.controller;

import com.store.backend.dtos.LoginDto;
import com.store.backend.dtos.RegisterDto;
import com.store.backend.mapper.RegisterMapper;
import com.store.backend.model.User;
import com.store.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {
        User user = userService.getUserByEmail(loginDto.getEmail());
        System.out.println(user);
        if (user != null && user.getPassword().equals(loginDto.getPassword())) {
            return "Login successful!";
        }
        return "Login failed!";
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterDto RegisterDto) {
        User user = RegisterMapper.mapRegisterDtoToUser(RegisterDto);

        if (userService.existsByEmail(user.getEmail())) {
            return "User already exists!";
        }

        userService.addUser(user);
        return "User registered!";
    }
}
