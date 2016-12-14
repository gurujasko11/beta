package App.model;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by janusz on 11.12.16.
 */
public class Order {

    static IntegerProperty ID = new SimpleIntegerProperty(0);
    IntegerProperty orderID;
    ObservableList<Position> positions;
    Customer customer;
    DoubleProperty total = new SimpleDoubleProperty(0);
    ObjectProperty<LocalDate> date;

    public Customer getCustomer() {
        return customer;
    }

    public IntegerProperty orderIDProperty() {
        return orderID;
    }

    public ObjectProperty<LocalDate> getDate(){
        return date;
    }

    public DoubleProperty getTotal(){
        return total;
    }

    public ObservableList<Position> getPositions() { return positions; }

    public Order(){
    }
    public Order(Customer customer) {
        this.date= new SimpleObjectProperty<LocalDate>(LocalDate.now());
        positions = FXCollections.observableArrayList(customer.getBasket().getPositions());//(customer.getBasket().getPositions().size());
        this.customer = customer;
        orderID = ID;
        //TODO
        //update ID (increment)
    }
}
