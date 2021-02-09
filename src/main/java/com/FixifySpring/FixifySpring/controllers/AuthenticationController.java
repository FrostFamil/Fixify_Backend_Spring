package com.FixifySpring.FixifySpring.controllers;

import com.FixifySpring.FixifySpring.RequestResponseFiles.LoginRequest;
import com.FixifySpring.FixifySpring.models.Fixer;
import com.FixifySpring.FixifySpring.models.User;
import com.FixifySpring.FixifySpring.service.UserService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RequestMapping("api/v2/auth")
@RestController
public class AuthenticationController {

    private final UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/test")
    public String test(){
        return userService.test();
    }

    @PostMapping("/signup")
    public ResponseEntity<?> userSignup(@Validated @NonNull @RequestBody User user) {
        return userService.userSignup(user);
    }

    @PostMapping("/fixerSignup")
    public ResponseEntity<?> fixerSignup(@Validated @NonNull @RequestBody Fixer fixer) {
        return userService.fixerSignup(fixer);
    }

    @PostMapping("/userLogin")
    public ResponseEntity<?> userLogin(@Validated @RequestBody LoginRequest loginRequest) {
        return userService.userLogin(loginRequest);
    }

    @PostMapping("/fixerLogin")
    public ResponseEntity<?> fixerLogin(@Validated @RequestBody LoginRequest loginRequest) {
        return userService.fixerLogin(loginRequest);
    }
}
