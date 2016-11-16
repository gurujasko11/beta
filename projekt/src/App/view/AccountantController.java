package App.view;


import App.MainApp;
import javafx.fxml.FXML;

public class AccountantController {
    MainApp mainApp;
    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }
    @FXML
    public void handleLogout(){
        mainApp.showWelcomeLayout();
    }

}
