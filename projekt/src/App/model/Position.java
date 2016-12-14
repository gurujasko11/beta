package App.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by janusz on 11.12.16.
 */
public class Position {
    private final Offer offer;
    private IntegerProperty quantity;

    public Position(Offer offer, int quantity) {
        this.offer = offer;
        this.quantity = new SimpleIntegerProperty(quantity);
    }

    public Offer getOffer() { return offer; }
    public IntegerProperty getQuantity() { return quantity; }
}
