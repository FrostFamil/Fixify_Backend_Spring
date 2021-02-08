package com.FixifySpring.FixifySpring.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Document(collection = "Fixer")
public class Fixer {

    @NotBlank
    private final String email;
    @NotBlank
    private final String password;
    @NotBlank
    private final String firstName;
    @NotBlank
    private final String lastName;
    @NotBlank
    private final String phone;
    private final String status;

    public Fixer(
            @JsonProperty("email") String email,
            @JsonProperty("password") String password,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("phone") String phone,
            @JsonProperty("status") String status) {

        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.status = status;
    }
}
