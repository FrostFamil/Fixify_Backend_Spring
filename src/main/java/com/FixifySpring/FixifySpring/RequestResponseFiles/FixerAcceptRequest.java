package com.FixifySpring.FixifySpring.RequestResponseFiles;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class FixerAcceptRequest {
    @NotBlank
    private String requestName;
    @NotBlank
    private String fixerId;
}
