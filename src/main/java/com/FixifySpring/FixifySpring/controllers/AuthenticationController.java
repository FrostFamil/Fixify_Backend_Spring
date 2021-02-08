package com.FixifySpring.FixifySpring.controllers;

import com.FixifySpring.FixifySpring.models.User;
import com.FixifySpring.FixifySpring.service.UserService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RequestMapping("api/v2")
@RestController
public class AuthenticationController {

    private final UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/test")
    public String test(@Validated @NonNull @RequestBody User user){
        return userService.test(user);
    }
}
