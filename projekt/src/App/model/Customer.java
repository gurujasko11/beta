package App.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Customer extends Account{
    private final Address address;
    private Basket basket;

    public Customer(){
        basket = new Basket();
        address = null;
    };
    public Customer(String log, String pas, AccountType typ) {
        super(log, pas, typ);
        address = null;
        basket = null;
    }
    public Customer(String log, String pas,String street, String postalCode, String city, String homeNumber, AccountType typ){
        super(log, pas, typ);
        basket = new Basket();
        address = new Address(street, postalCode, city, homeNumber);
    }
    public Address getAddress(){
        return this.address.getAddress();
    }

    public Basket getBasket() {
        return basket;
    }
    public void clearBasket(){
        basket.clearBasket();
    }
    public Order goCheckOut() {
        Order ord = new Order(this);
        clearBasket();
        return ord;
    }
    public StringProperty getName(){
        if(this instanceof Person){
            return ((Person)this).getFirstName();
        }
        else if(this instanceof Business){
            return ((Business)this).getName();
        }
        else
            return null;
    }
    public StringProperty getSecondName(){
        if(this instanceof Person){
            return ((Person)this).getLastName();
        }
        else if(this instanceof Business){
            return ((Business)this).getNip();
        }
        else
            return null;
    }
}


