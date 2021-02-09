package com.FixifySpring.FixifySpring.RequestResponseFiles;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class CardAddingRequest {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String cardNumber;
    @NotBlank
    private String expMonth;
    @NotBlank
    private int expYear;
}
