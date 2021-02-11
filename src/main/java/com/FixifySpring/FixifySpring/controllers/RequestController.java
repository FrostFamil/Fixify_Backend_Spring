package com.FixifySpring.FixifySpring.controllers;

import com.FixifySpring.FixifySpring.models.FixerPushNotification;
import com.FixifySpring.FixifySpring.models.Request;
import com.FixifySpring.FixifySpring.service.NotificationService;
import com.FixifySpring.FixifySpring.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v2/request")
@RestController
public class RequestController {

    private final RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/addUsersRequest")
    public ResponseEntity<?> addUsersRequest(@Validated @RequestBody Request request){
        return requestService.addUsersRequest(request);
    }

    @GetMapping("/getRequestsForUserByStatus")
    public ResponseEntity<?> getRequestsForUserByStatus(@RequestParam("creator") String creator, @RequestParam("status") String status){
        return requestService.getRequestsForUserByStatus(creator, status);
    }

    @GetMapping("/fixerGetRelatedRequests")
    public ResponseEntity<?> fixerGetRelatedRequests(@RequestParam("serviceType") String serviceType, @RequestParam("status") String status){
        return requestService.fixerGetRelatedRequests(serviceType, status);
    }
}
