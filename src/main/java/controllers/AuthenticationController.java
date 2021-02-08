package controllers;

import models.User;
import org.springframework.beans.factory.annotation.*;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.UserService;


@RequestMapping("api/v2")
public class AuthenticationController {

    private final UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/test")
    public void test(@Validated @NonNull @RequestBody User user){
        userService.test(user);
    }
}
