package App.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import static App.model.AccountType.PERSON;


/**
 * Created by janusz on 14.11.16.
 */
public class Person extends Customer {
    private final StringProperty firstName;
    private final StringProperty lastName;

    public Person() {
        super();
        lastName = null;
        firstName = null;
    }
    public Person(String fname, String lname,String log, String pas,String street, String postalCode, String city){
        super(log, pas, street, postalCode, city, PERSON);
        lastName = new SimpleStringProperty(lname);
        firstName = new SimpleStringProperty(fname);
    }
    public void setFirstName(String fname){
        this.firstName.set(fname);
    }
    public void setLastName(String lname){
        this.lastName.set(lname);
    }
    public String getFirstName(){
        return firstName.get();
    }
    public String getLastName(){
        return lastName.get();
    }
}
