package App.view;

import App.MainApp;

/**
 * Created by busz on 13.11.16.
 */
public class ClientsController {

    MainApp mainApp;

    public void handleLogoutButton() {
        mainApp.showWelcomeLayout();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
