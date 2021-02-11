package com.FixifySpring.FixifySpring.repository;

import com.FixifySpring.FixifySpring.models.FixerPushNotification;
import com.FixifySpring.FixifySpring.models.Request;
import com.FixifySpring.FixifySpring.models.User;
import com.FixifySpring.FixifySpring.models.UserPushNotification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RequestRepository extends MongoRepository<Request, Long> {
    Optional<Request> findRequestByRequestName(String requestName);
    Optional<Request> findRequestByCreatorAndAvailable(String creator, String available);
    List<Request> findAllByCreatorAndStatus(String creator, String status);
    List<Request> findAllByServiceTypeAndStatus(String serviceType, String status);
    List<Request> findAllByAcceptorAndStatus(String acceptor, String status);
}
