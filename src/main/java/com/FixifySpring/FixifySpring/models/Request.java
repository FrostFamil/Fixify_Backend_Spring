package com.FixifySpring.FixifySpring.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Setter
@Getter
@Document(collection = "Request")
public class Request {
    @Id
    private String id;
    @NotBlank
    private String requestName;
    @NotBlank
    private String latitudeFrom;
    @NotBlank
    private String longitudeFrom;
    @NotBlank
    private String creator;
    @NotBlank
    private String acceptor;
    @NotBlank
    private String status;
    @NotBlank
    private String available;
    @NotBlank
    private String priceStatus;
    @NotBlank
    private String price;
    @NotBlank
    private String paymentType;
    @NotBlank
    private String problem;
    @NotBlank
    private String serviceType;
    @NotBlank
    private String scheduled;
    @NotBlank
    private String address;

    public Request(
            @JsonProperty("latitudeFrom") String latitudeFrom,
            @JsonProperty("longitudeFrom") String longitudeFrom,
            @JsonProperty("creator") String creator,
            @JsonProperty("acceptor") String acceptor,
            @JsonProperty("status") String status,
            @JsonProperty("available") String available,
            @JsonProperty("priceStatus") String priceStatus,
            @JsonProperty("price") String price,
            @JsonProperty("paymentType") String paymentType,
            @JsonProperty("problem") String problem,
            @JsonProperty("serviceType") String serviceType,
            @JsonProperty("scheduled") String scheduled,
            @JsonProperty("address") String address) {

        this.id = UUID.randomUUID().toString();
        this.requestName = this.id;
        this.latitudeFrom = latitudeFrom;
        this.longitudeFrom = longitudeFrom;
        this.creator = creator;
        this.acceptor = acceptor;
        this.status = status;
        this.available = available;
        this.priceStatus = priceStatus;
        this.price = price;
        this.paymentType = paymentType;
        this.problem = problem;
        this.serviceType = serviceType;
        this.scheduled = scheduled;
        this.address = address;
    }
}
