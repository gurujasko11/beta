package App.view;


import App.MainApp;
import javafx.fxml.FXML;

public class SupplierController {

    MainApp mainApp;

    @FXML
    public void handleLogout(){
        mainApp.showWelcomeLayout();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
