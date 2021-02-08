package reusableClasses;

import java.util.UUID;

public class Card {
    private final UUID id;
    private final String cardNumber;
    private final String expMonth;
    private final int expYear;

    public Card(UUID id, String cardNumber, String expMonth, int expYear) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }
}
