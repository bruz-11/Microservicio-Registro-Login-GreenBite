package com.duoc.auth.controller;

import com.duoc.auth.dto.UserDTO;
import com.duoc.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody UserDTO userDto) {
        return authService.registrar(userDto);
    }
}