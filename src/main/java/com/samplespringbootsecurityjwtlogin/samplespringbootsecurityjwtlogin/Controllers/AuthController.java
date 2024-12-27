package com.samplespringbootsecurityjwtlogin.samplespringbootsecurityjwtlogin.Controllers;


import com.samplespringbootsecurityjwtlogin.samplespringbootsecurityjwtlogin.dto.JWTResponse;
import com.samplespringbootsecurityjwtlogin.samplespringbootsecurityjwtlogin.dto.UserDTO;
import com.samplespringbootsecurityjwtlogin.samplespringbootsecurityjwtlogin.services.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @Slf4j
    @RequiredArgsConstructor
    @CrossOrigin(originPatterns = "*")
    @RequestMapping("/auth")
    public class AuthController {

        private final AuthService authService;

        @PostMapping("/login")
        public ResponseEntity<JWTResponse> login(@RequestBody UserDTO userDTO)  {
            log.info("login user");
            return ResponseEntity.status(HttpStatus.OK).body(authService.login(userDTO));
        }

    }

