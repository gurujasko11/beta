package App.view;

import App.MainApp;
import javafx.fxml.FXML;

/**
 * Created by pPanek on 2016-11-14.
 */
public class ClientOffersController {

    MainApp mainApp;


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    public void handleBack(){
        mainApp.showWelcomeLayout();
    }
}
