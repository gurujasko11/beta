package App.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by janusz on 11.12.16.
 */
public enum ProductType {
    SERVICE,
    LEASE,
    ITEM;
    public StringProperty getTypeName() {
        return (new SimpleStringProperty(this.name()));
    }
}
