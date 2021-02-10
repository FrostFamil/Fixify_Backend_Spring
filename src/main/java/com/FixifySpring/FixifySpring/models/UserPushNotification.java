package com.FixifySpring.FixifySpring.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.FixifySpring.FixifySpring.reusableClasses.Card;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Setter
@Getter
@Document(collection = "UserPushNotifications")
public class UserPushNotification {

    @Id
    private String id;
    @NotBlank
    private String token;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String userId;

    public UserPushNotification(
            @JsonProperty("token") String token,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("userId") String userId) {

        this.id = UUID.randomUUID().toString();
        this.token = token;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
    }
}
