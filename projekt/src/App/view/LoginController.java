package App.view;

import App.MainApp;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by busz on 12.11.16.
 */

public class LoginController {

    Stage dialogStage;
    private boolean logInClicked = false;
    StringProperty loginString;
    MainApp mainApp;

    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    private void initialize() {
    }

    public boolean isLogInClicked(){
        return logInClicked;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setLoginString(StringProperty loginString){
        this.loginString = loginString;
    }

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }


    @FXML
    private void handleLogIn() {

            if(mainApp.getAccounts().get( login.getText() )!= null &&
                    password.getText().equals(mainApp.getAccounts().get( login.getText() ).getPassword())) {
                loginString.set(login.getText());
                logInClicked = true;
                dialogStage.close();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
               alert.setHeaderText("Caution!");
               alert.setContentText("Wrong login or password");
               alert.showAndWait();
            }
        }

    }
