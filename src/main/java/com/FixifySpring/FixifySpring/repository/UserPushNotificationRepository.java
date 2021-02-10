package com.FixifySpring.FixifySpring.repository;

import com.FixifySpring.FixifySpring.models.FixerPushNotification;
import com.FixifySpring.FixifySpring.models.User;
import com.FixifySpring.FixifySpring.models.UserPushNotification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserPushNotificationRepository extends MongoRepository<UserPushNotification, Long> {
    Optional<UserPushNotification> findByUserId(String userId);
}
