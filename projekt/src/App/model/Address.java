package App.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Address{
    private final StringProperty street;
    private final StringProperty postalCode;
    private final StringProperty city;

    public Address(){
        city = null;
        postalCode = null;
        street = null;
    }
    public Address(String street, String postalCode, String city) {
        this.street = new SimpleStringProperty(street);
        this.postalCode = new SimpleStringProperty(postalCode);
        this.city = new SimpleStringProperty(city);
    }
    public Address getAddress(){
        return new Address(this.getStreet(),this.getPostalCode(),this.getCity());
    }
    public String getStreet(){
        return street.get();
    }
    public String getCity(){
        return city.get();
    }
    public String getPostalCode(){
        return postalCode.get();
    }
    public void setStreet(String city){
        this.city.set(city);
    }
    public void setPostalCode(String postal){
        this.postalCode.set(postal);
    }
    public void setCity(String city){
        this.city.set(city);
    }
}
