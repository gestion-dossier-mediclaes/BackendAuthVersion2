package com.esi.msauth.controller;


import com.esi.msauth.dto.AuthenticationResponse;
import com.esi.msauth.dto.LoginRequest;
import com.esi.msauth.dto.RefreshTokenRequest;
import com.esi.msauth.dto.RegisterRequest;
import com.esi.msauth.model.User;
import com.esi.msauth.service.AuthService;
import com.esi.msauth.service.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;
     @PostMapping("/signup")
     public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
         authService.signup(registerRequest);
         return new ResponseEntity<>("User Registration Successful",
                 HttpStatus.OK);


    }
    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successfully", OK);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
      authService.login(loginRequest);
      String var="User Registration Successful";
        return new ResponseEntity<>(var,
                HttpStatus.OK);
    }

    @GetMapping ("/all")
    public ResponseEntity<List<User>> getAllUsers () {
        List<User> users = authService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
