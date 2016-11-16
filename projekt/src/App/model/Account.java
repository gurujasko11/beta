package App.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by janusz on 14.11.16.
 */
public class Account {
    private final StringProperty login;
    private final StringProperty password;
    private final AccountType type;
    public Account(){
        login = null;
        password = null;
        type = null;
    };
    public Account(String log, String pas, AccountType typ){
        login = new SimpleStringProperty(log);
        password = new SimpleStringProperty(pas);
        type = typ;
    }

    public String getLogin(){
        return login.get();
    }
    public String getPassword(){
        return password.get();
    }
    public void setPassword(String pas){
        password.set(pas);
    }
    public void setLogin(String log){
        login.set(log);
    }
    public AccountType getType(){
        return type;
    }



}

