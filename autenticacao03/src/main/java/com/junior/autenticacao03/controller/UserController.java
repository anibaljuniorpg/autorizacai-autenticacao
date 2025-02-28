package com.junior.autenticacao03.controller;

import com.junior.autenticacao03.dtos.LoginRequestDTO;
import com.junior.autenticacao03.dtos.LoginResponseDTO;
import com.junior.autenticacao03.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO requestDTO){
        LoginResponseDTO responseDTO = authService.login(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }
    @PostMapping("/register")
    public ResponseEntity<LoginResponseDTO> register(@RequestBody LoginRequestDTO requestDTO){
        LoginResponseDTO responseDTO = authService.register(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

}
