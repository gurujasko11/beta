package App.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Address{
    private final StringProperty street;
    private final StringProperty postalCode;
    private final StringProperty city;
    private final StringProperty number;

    public Address(){
        city = null;
        postalCode = null;
        street = null;
        number = null;
    }
    public Address(String street, String postalCode, String city, String no) {
        this.street = new SimpleStringProperty(street);
        this.postalCode = new SimpleStringProperty(postalCode);
        this.city = new SimpleStringProperty(city);
        this.number = new SimpleStringProperty(no);
    }
    public String getAddressAsString(){
        StringBuilder sb = new StringBuilder();
        sb.append(city.getValue());
        sb.append(" "+street.getValue());
        sb.append(" "+number.getValue());
        sb.append(" "+postalCode.getValue());
        return sb.toString();
    }
    public Address getAddress(){
        return new Address(this.getStreet(),this.getPostalCode(),this.getCity(), this.getNumber());
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
    public String getNumber() { return number.get(); }
    public void setStreet(String city){
        this.city.set(city);
    }
    public void setPostalCode(String postal){
        this.postalCode.set(postal);
    }
    public void setCity(String city){
        this.city.set(city);
    }
    public void setNumber(String no) { this.city.set(no);}
}
