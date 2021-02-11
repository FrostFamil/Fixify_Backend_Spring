package com.FixifySpring.FixifySpring.controllers;

import com.FixifySpring.FixifySpring.RequestResponseFiles.FixerAcceptRequest;
import com.FixifySpring.FixifySpring.RequestResponseFiles.FixerSetPriceRequest;
import com.FixifySpring.FixifySpring.RequestResponseFiles.UpdateProfileRequest;
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

    @GetMapping("/getRequestsForFixerByStatus")
    public ResponseEntity<?> getRequestsForFixerByStatus(@RequestParam("acceptor") String acceptor, @RequestParam("status") String status){
        return requestService.getRequestsForFixerByStatus(acceptor, status);
    }

    @GetMapping("/userFinishRequest")
    public ResponseEntity<?> userFinishRequest(@RequestParam("requestName") String requestName) {
        return requestService.userFinishRequest(requestName);
    }

    @PostMapping("/fixerAcceptRequest")
    public ResponseEntity<?> fixerAcceptRequest(@Validated @RequestBody FixerAcceptRequest fixerAcceptRequest) {
        return requestService.fixerAcceptRequest(fixerAcceptRequest);
    }

    @GetMapping("/fixerSeeRequest")
    public ResponseEntity<?> fixerSeeRequest(@RequestParam("requestName") String requestName) {
        return requestService.fixerSeeRequest(requestName);
    }

    @GetMapping("/userFindHisCurrentRequest")
    public ResponseEntity<?> userFindHisCurrentRequest(@RequestParam("creator") String creator) {
        return requestService.userFindHisCurrentRequest(creator);
    }

    @DeleteMapping("/deleteRequest")
    public ResponseEntity<?> deleteRequest(@RequestParam("requestName") String requestName) {
        return requestService.deleteRequest(requestName);
    }

    @PutMapping("/fixerSetPriceForRequest")
    public ResponseEntity<?> fixerSetPriceForRequest(@Validated @RequestBody FixerSetPriceRequest fixerSetPriceRequest) {
        return requestService.fixerSetPriceForRequest(fixerSetPriceRequest);
    }

    @GetMapping("/userAcceptPriceForCurrentRequest")
    public ResponseEntity<?> userAcceptPriceForCurrentRequest(@RequestParam("requestName") String requestName) {
        return requestService.userAcceptPriceForCurrentRequest(requestName);
    }

    @GetMapping("/userDeclinePriceForCurrentRequest")
    public ResponseEntity<?> userDeclinePriceForCurrentRequest(@RequestParam("requestName") String requestName) {
        return requestService.userDeclinePriceForCurrentRequest(requestName);
    }
}
