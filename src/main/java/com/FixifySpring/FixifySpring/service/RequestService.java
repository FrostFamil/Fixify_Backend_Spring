package com.FixifySpring.FixifySpring.service;

import com.FixifySpring.FixifySpring.RequestResponseFiles.FixerAcceptRequest;
import com.FixifySpring.FixifySpring.RequestResponseFiles.FixerSetPriceRequest;
import com.FixifySpring.FixifySpring.RequestResponseFiles.UpdateProfileRequest;
import com.FixifySpring.FixifySpring.models.FixerPushNotification;
import com.FixifySpring.FixifySpring.models.Request;
import com.FixifySpring.FixifySpring.models.User;
import com.FixifySpring.FixifySpring.repository.FixerRepository;
import com.FixifySpring.FixifySpring.repository.RequestRepository;
import com.FixifySpring.FixifySpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

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

    public ResponseEntity<?> getRequestsForFixerByStatus(String acceptor, String status) {
        List<Request> existRequests = requestRepository.findAllByAcceptorAndStatus(acceptor, status);
        if (existRequests.isEmpty()) {
            return new ResponseEntity<>("Fixer requests do not exist with this status", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(existRequests);
    }

    public ResponseEntity<?> userFinishRequest(String requestName) {
        //request check
        Optional<Request> existRequest = requestRepository.findRequestByRequestName(requestName);
        if (existRequest.isEmpty()) {
            return new ResponseEntity<>("Request does not exist with this ID", HttpStatus.BAD_REQUEST);
        }

        existRequest.filter(p -> {
            p.setStatus("Finished");
            p.setAvailable("No");
            p.setPriceStatus("Paid");
            return true;
        });
        requestRepository.save(existRequest.get());

        return ResponseEntity.ok(existRequest);
    }

    public ResponseEntity<?> fixerAcceptRequest(FixerAcceptRequest fixerAcceptRequest) {
        //request check
        Optional<Request> existRequest = requestRepository.findRequestByRequestName(fixerAcceptRequest.getRequestName());
        if (existRequest.isEmpty()) {
            return new ResponseEntity<>("Request does not exist with this ID", HttpStatus.BAD_REQUEST);
        }

        existRequest.filter(p -> {
            p.setAcceptor(fixerAcceptRequest.getFixerId());
            p.setStatus("Accepted");
            return true;
        });
        requestRepository.save(existRequest.get());

        return ResponseEntity.ok(existRequest);
    }

    public ResponseEntity<?> fixerSeeRequest(String requestName) {
        //request check
        Optional<Request> existRequest = requestRepository.findRequestByRequestName(requestName);
        if (existRequest.isEmpty()) {
            return new ResponseEntity<>("Request does not exist with this ID", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(existRequest);
    }

    public ResponseEntity<?> userFindHisCurrentRequest(String creator) {
        //request check
        Optional<Request> existRequest = requestRepository.findRequestByCreatorAndAvailable(creator, "Yes");
        if (existRequest.isEmpty()) {
            return new ResponseEntity<>("This User does not have any available request", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(existRequest);
    }

    public ResponseEntity<?> deleteRequest(String requestName) {
        //request check
        Optional<Request> existRequest = requestRepository.findRequestByRequestName(requestName);
        if (existRequest.isEmpty()) {
            return new ResponseEntity<>("Request with this Id does not exist", HttpStatus.BAD_REQUEST);
        }

        requestRepository.deleteByRequestName(requestName);
        return ResponseEntity.ok("Request deleted successfully");
    }

    public ResponseEntity<?> fixerSetPriceForRequest(FixerSetPriceRequest fixerSetPriceRequest) {
        //request check
        Optional<Request> existRequest = requestRepository.findRequestByRequestName(fixerSetPriceRequest.getRequestName());
        if (existRequest.isEmpty()) {
            return new ResponseEntity<>("Request does not exist with this ID", HttpStatus.BAD_REQUEST);
        }

        existRequest.filter(p -> {
            p.setPriceStatus("Decided");
            p.setPrice(fixerSetPriceRequest.getPrice());
            p.setAcceptor(fixerSetPriceRequest.getFixerId());
            p.setStatus("Pending");
            return true;
        });
        requestRepository.save(existRequest.get());

        return ResponseEntity.ok(existRequest);
    }

    public ResponseEntity<?> userAcceptPriceForCurrentRequest(String requestName) {
        //request check
        Optional<Request> existRequest = requestRepository.findRequestByRequestName(requestName);
        if (existRequest.isEmpty()) {
            return new ResponseEntity<>("Request does not exist with this ID", HttpStatus.BAD_REQUEST);
        }

        existRequest.filter(p -> {
            p.setPriceStatus("Done");
            return true;
        });
        requestRepository.save(existRequest.get());

        return ResponseEntity.ok(existRequest);
    }

    public ResponseEntity<?> userDeclinePriceForCurrentRequest(String requestName) {
        //request check
        Optional<Request> existRequest = requestRepository.findRequestByRequestName(requestName);
        if (existRequest.isEmpty()) {
            return new ResponseEntity<>("Request does not exist with this ID", HttpStatus.BAD_REQUEST);
        }

        existRequest.filter(p -> {
            p.setPriceStatus("Not Decided");
            p.setStatus("Not Accepted");
            p.setPrice("0");
            return true;
        });
        requestRepository.save(existRequest.get());

        return ResponseEntity.ok(existRequest);
    }
}
