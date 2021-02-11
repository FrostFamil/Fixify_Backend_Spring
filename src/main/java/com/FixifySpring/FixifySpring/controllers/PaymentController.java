package com.FixifySpring.FixifySpring.controllers;

import com.FixifySpring.FixifySpring.RequestResponseFiles.ChargeRequest;
import com.FixifySpring.FixifySpring.models.FixerPushNotification;
import com.FixifySpring.FixifySpring.service.PaymentService;
import com.FixifySpring.FixifySpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Charge;

@RequestMapping("api/v2/payment")
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService PaymentService) {
        this.paymentService = PaymentService;
    }

    @PostMapping("/chargeUser")
    public ResponseEntity<?> chargeUser(@Validated @RequestBody ChargeRequest chargeRequest){
        return paymentService.chargeUser(chargeRequest);
    }
}
