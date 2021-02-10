package com.FixifySpring.FixifySpring.service;

import com.FixifySpring.FixifySpring.models.FixerPushNotification;
import com.FixifySpring.FixifySpring.models.UserPushNotification;
import com.FixifySpring.FixifySpring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private FixerPushNotificationRepository fixerPushNotificationRepository;
    @Autowired
    private UserPushNotificationRepository userPushNotificationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FixerRepository fixerRepository;

    public ResponseEntity<?> addFixersPushToken(FixerPushNotification fixerPushNotiRequest) {
        fixerPushNotificationRepository.save(fixerPushNotiRequest);
        return ResponseEntity.ok(fixerPushNotiRequest);
    }

    public ResponseEntity<?> addUsersPushToken(UserPushNotification userPushNotification) {
        userPushNotificationRepository.save(userPushNotification);
        return ResponseEntity.ok(userPushNotification);
    }


}
