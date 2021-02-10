package com.FixifySpring.FixifySpring.repository;

import com.FixifySpring.FixifySpring.models.Fixer;
import com.FixifySpring.FixifySpring.models.FixerPushNotification;
import com.FixifySpring.FixifySpring.models.User;
import com.FixifySpring.FixifySpring.models.UserPushNotification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FixerPushNotificationRepository extends MongoRepository<FixerPushNotification, Long> {
    Optional<FixerPushNotification> findByFixerId(String fixerId);
    List<FixerPushNotification> findAllByServiceType(String serviceType);
}
