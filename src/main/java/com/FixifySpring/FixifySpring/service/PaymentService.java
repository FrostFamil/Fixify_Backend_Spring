package com.FixifySpring.FixifySpring.service;

import com.FixifySpring.FixifySpring.RequestResponseFiles.ChargeRequest;
import com.FixifySpring.FixifySpring.models.UserPushNotification;
import com.stripe.Stripe;
import com.stripe.model.Charge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.Optional;

@Service
public class PaymentService {

    @PostConstruct
    public void init() {
        Stripe.apiKey = "STRIPE_SECRET_TOKEN";
    }

    public ResponseEntity<?> chargeUser(ChargeRequest chargeRequest) {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", chargeRequest.getCurrency());
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("source", chargeRequest.getStripeToken());
        try {
            Charge charge = Charge.create(chargeParams);
            return new ResponseEntity<>(charge.getStatus(), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
        }
    }
}
