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
@Document(collection = "FixerPushNotifications")
public class FixerPushNotification {

    @Id
    private String id;
    @NotBlank
    private String token;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String fixerId;
    @NotBlank
    private String serviceType;

    public FixerPushNotification(
            @JsonProperty("token") String token,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("fixerId") String fixerId,
            @JsonProperty("serviceType") String serviceType) {

        this.id = UUID.randomUUID().toString();
        this.token = token;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fixerId = fixerId;
        this.serviceType = serviceType;
    }
}
