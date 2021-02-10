package com.FixifySpring.FixifySpring.controllers;

import com.FixifySpring.FixifySpring.models.FixerPushNotification;
import com.FixifySpring.FixifySpring.models.UserPushNotification;
import com.FixifySpring.FixifySpring.service.NotificationService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RequestMapping("api/v2/notification")
@RestController
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/addFixersPushToken")
    public ResponseEntity<?> addFixersPushToken(@Validated @RequestBody FixerPushNotification fixerPushNotiRequest){
        return notificationService.addFixersPushToken(fixerPushNotiRequest);
    }

    @GetMapping("/getFixersPushToken")
    public ResponseEntity<?> getFixersPushToken(@RequestParam("serviceType") String serviceType){
        return notificationService.getFixersPushToken(serviceType);
    }

    @PostMapping("/addUsersPushToken")
    public ResponseEntity<?> addUsersPushToken(@Validated @RequestBody UserPushNotification userPushNotification){
        return notificationService.addUsersPushToken(userPushNotification);
    }

    @GetMapping("/getUsersPushToken")
    public ResponseEntity<?> getUsersPushToken(@RequestParam("userId") String userId){
        return notificationService.getUsersPushToken(userId);
    }
}
