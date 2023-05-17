package com.store.backend.controller;

import com.store.backend.dtos.LoginDto;
import com.store.backend.dtos.RegisterDto;
import com.store.backend.mapper.RegisterMapper;
import com.store.backend.model.User;
import com.store.backend.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public @ResponseBody
    ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        User user = userService.getUserByEmail(loginDto.getEmail());
        System.out.println(user);
        if (user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        if (user.getPassword().equals(loginDto.getPassword())) {

            try {
                Cookie sessionCookie = userService.genUserSessionCookie(user);
                sessionCookie.setMaxAge(10 * 60);
                sessionCookie.setPath("/");
                response.addCookie(sessionCookie);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

            return ResponseEntity.ok().build();
        }
        
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping("/register")
    public @ResponseBody
    String register(@RequestBody RegisterDto RegisterDto) {
        User user = RegisterMapper.mapRegisterDtoToUser(RegisterDto);

        if (userService.existsByEmail(user.getEmail())) {
            return "User already exists!";
        }

        userService.addUser(user);
        return "User registered!";
    }
}
