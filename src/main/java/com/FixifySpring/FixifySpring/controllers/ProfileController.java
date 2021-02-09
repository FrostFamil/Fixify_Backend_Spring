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


@RequestMapping("api/v2/profile")
@RestController
public class ProfileController {

    private final UserService userService;

    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUserProfile")
    public ResponseEntity<?> getUserProfile(@RequestParam("email") String email){
        return userService.getUserProfile(email);
    }

    @GetMapping("/getFixerProfile")
    public ResponseEntity<?> getFixerProfile(@RequestParam("email") String email){
        return userService.getFixerProfile(email);
    }
}
