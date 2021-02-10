package com.FixifySpring.FixifySpring.service;

import com.FixifySpring.FixifySpring.models.Fixer;
import com.FixifySpring.FixifySpring.models.FixerPushNotification;
import com.FixifySpring.FixifySpring.models.UserPushNotification;
import com.FixifySpring.FixifySpring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<FixerPushNotification> existFixerToken = fixerPushNotificationRepository.findByFixerId(fixerPushNotiRequest.getFixerId());

        if(existFixerToken.isEmpty()) {
            fixerPushNotificationRepository.save(fixerPushNotiRequest);
            return ResponseEntity.ok(fixerPushNotiRequest);
        }else {
            return ResponseEntity.ok(existFixerToken);
        }

    }

    public ResponseEntity<?> getFixersPushToken(String serviceType) {
        List<FixerPushNotification> existFixerToken = fixerPushNotificationRepository.findAllByServiceType(serviceType);
        if (existFixerToken.isEmpty()) {
            return new ResponseEntity<>("Fixer tokens does not exist with this serviceType", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(existFixerToken);
    }

    public ResponseEntity<?> addUsersPushToken(UserPushNotification userPushNotification) {
        Optional<UserPushNotification> existUserToken = userPushNotificationRepository.findByUserId(userPushNotification.getUserId());

        if(existUserToken.isEmpty()){
            userPushNotificationRepository.save(userPushNotification);
            return ResponseEntity.ok(userPushNotification);
        } else {
            return ResponseEntity.ok(existUserToken);
        }
    }

    public ResponseEntity<?> getUsersPushToken(String userId) {
        Optional<UserPushNotification> existUserToken = userPushNotificationRepository.findByUserId(userId);
        if (existUserToken.isEmpty()) {
            return new ResponseEntity<>("User tokens does not exist with this serviceType", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(existUserToken);
    }


}
