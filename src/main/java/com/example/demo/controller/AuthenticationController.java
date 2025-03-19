package com.example.demo.controller;



import com.example.demo.dto.AuthUserDTO;
import com.example.demo.dto.LoginDTO;
import com.example.demo.model.AuthUser;
import com.example.demo.repository.AuthUserRepository;
import com.example.demo.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;
    private AuthUserRepository authUserRepository;

    @PostMapping("/register")
    public String register(@RequestBody AuthUserDTO userDTO) {
        return authenticationService.register(userDTO);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        return authenticationService.login(loginDTO).toString();
    }
    @GetMapping("/users")
    public List<AuthUser> getAllUsers() {
        return authUserRepository.findAll();
    }

}
