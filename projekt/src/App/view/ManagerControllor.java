package App.view;

import App.MainApp;
import javafx.fxml.FXML;

/**
 * Created by busz on 14.11.16.
 */
public class ManagerControllor {

    MainApp mainApp;

    @FXML
    public void handleLogout(){
        mainApp.showWelcomeLayout();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
