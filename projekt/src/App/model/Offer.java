package App.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Created by janusz on 11.12.16.
 */
public class Offer {
    private final Product product;
    private final DoubleProperty price;
    private final DoubleProperty tax;

    public Product getProduct() {
        return product;
    }

    public DoubleProperty getPrice() {
        return price;
    }

    public DoubleProperty getTax() {
        return tax;
    }

    public Offer(Product product, double price, double tax) {
        this.product = product;
        this.price = new SimpleDoubleProperty(price);
        this.tax = new SimpleDoubleProperty(tax);
    }
}
