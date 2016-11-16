package App.view;

import App.MainApp;
import App.model.AccountType;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

/**
 * Created by busz on 12.11.16.
 */
public class WelcomeLayoutController {

    MainApp mainApp;

    @FXML
    private void handleViewOffersButton() {
        mainApp.showClientOffersLayout();
    }

    @FXML
    private void handleLogInButton() {
        StringProperty loginString = new SimpleStringProperty();
        boolean signInClicked = mainApp.showLoginDialog(loginString);
        if(signInClicked){
            login( mainApp.getAccounts().get( loginString.get() ).getType() );
        }
    }

    private void login(AccountType type) {
        switch (type){
            case ACCOUNTANT:
                mainApp.showAccountantLayout();
                break;
            case SUPPLIER:
                mainApp.showSupplierLayout();
                break;
            case MANAGER:
                mainApp.showManagerLayout();
                break;
            case DBADMIN:
                mainApp.showClientLayout();
                break;
            case PERSON:
                System.out.println("You're logged in.");
                mainApp.showClientOffersLayout();
                break;
            case BUSINESS:
                break;
        }
    }

    @FXML
    private void handleRegisterButton() {
        mainApp.showRegisterLayout();
    }

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }
}
