package models;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import reusableClasses.Card;

import javax.validation.constraints.NotBlank;
import java.util.*;

public class User {

    @Id
    private final String id;
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
    private final Card cards;

    public User(
            @JsonProperty("id") String id,
            @JsonProperty("email") String email,
            @JsonProperty("password") String password,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("phone") String phone,
            @JsonProperty("status") String status,
            @JsonProperty("cards") Card cards) {

        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.status = status;
        this.cards = cards;
    }
}
