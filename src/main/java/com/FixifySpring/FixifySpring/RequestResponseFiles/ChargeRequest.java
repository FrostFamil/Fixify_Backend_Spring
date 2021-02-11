package com.FixifySpring.FixifySpring.RequestResponseFiles;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class ChargeRequest {

    private Integer amount;
    @NotBlank
    private String currency;
    @NotBlank
    private  String description;
    @NotBlank
    private String stripeToken;
}
