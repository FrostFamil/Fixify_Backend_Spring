package com.FixifySpring.FixifySpring.reusableClasses;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class Card {
    private final UUID id;
    private final String cardNumber;
    private final String expMonth;
    private final int expYear;

    public Card(String cardNumber, String expMonth, int expYear) {
        this.id = UUID.randomUUID();
        this.cardNumber = cardNumber;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }
}
