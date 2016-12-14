package App.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import static App.model.AccountType.BUSINESS;

/**
 * Created by janusz on 14.11.16.
 */
public class Business extends Customer{
        private final StringProperty name;
        private final StringProperty nip;

        public Business() {
            super();
            name= null;
            nip= null;
        }
        public Business(String name, String nip,String log, String pas,String street, String postalCode, String homeNumber, String city){
            super(log, pas, street, postalCode, city, homeNumber, BUSINESS);
            this.name = new SimpleStringProperty(name);
            this.nip = new SimpleStringProperty(nip);
        }
        public void setNip(String nip){
            this.nip.set(nip);
        }
        public void setName(String name){
            this.name.set(name);
        }
        public StringProperty getNip(){
            return new SimpleStringProperty(this.nip.get());
        }
        public StringProperty getName(){
            return new SimpleStringProperty(this.name.get());
        }

}
