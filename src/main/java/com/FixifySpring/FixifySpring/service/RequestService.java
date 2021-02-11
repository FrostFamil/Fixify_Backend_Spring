package com.FixifySpring.FixifySpring.service;

import com.FixifySpring.FixifySpring.models.FixerPushNotification;
import com.FixifySpring.FixifySpring.models.Request;
import com.FixifySpring.FixifySpring.repository.FixerRepository;
import com.FixifySpring.FixifySpring.repository.RequestRepository;
import com.FixifySpring.FixifySpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FixerRepository fixerRepository;

    public ResponseEntity<?> addUsersRequest(Request request) {
        requestRepository.save(request);
        return ResponseEntity.ok(request);
    }

    public ResponseEntity<?> getRequestsForUserByStatus(String creator, String status) {
        List<Request> existRequests = requestRepository.findAllByCreatorAndStatus(creator, status);
        if (existRequests.isEmpty()) {
            return new ResponseEntity<>("User requests do not exist with this status", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(existRequests);
    }

    public ResponseEntity<?> fixerGetRelatedRequests(String serviceType, String status) {
        List<Request> existRequests = requestRepository.findAllByServiceTypeAndStatus(serviceType, status);
        if (existRequests.isEmpty()) {
            return new ResponseEntity<>("No New requests with this service type", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(existRequests);
    }
}
