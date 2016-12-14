package App.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by janusz on 11.12.16.
 */
public class Product {
    private final StringProperty Name;
    private final ProductType tpye;
    public Product(String name, ProductType tpye) {
        Name = new SimpleStringProperty(name);
        this.tpye = tpye;
    }

    public StringProperty getName() {
        return Name;
    }

    public ProductType getTpye() {
        return tpye;
    }
}
