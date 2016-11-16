package App.view;

import  App.MainApp;
import App.model.Account;
import App.model.AccountType;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by janusz on 14.11.16.
 */
public class CreateAccountController {
    Stage dialogStage;
    private boolean confirmClicked = false;
    MainApp mainApp;
    @FXML
    private TextField firstName;

    @FXML
    private TextField secondName;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextField confirmPassword;

    @FXML
    private TextField city;

    @FXML
    private TextField street;
    //TO_DO
    //add email no phone no fields

    public boolean isConfirmClicked() {return confirmClicked;}

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean checkData(){
        if(username.getText().isEmpty()) return false;
        if(password.getText().isEmpty()) return false;
        return true;
    }
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    @FXML
    private void handleConfirm(){
        if(checkData() == true){
            mainApp.getAccounts().put(username.getText(), new Account( username.getText(),password.getText(), AccountType.PERSON));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("You had created new account");
            alert.setContentText("gz");
            alert.showAndWait();
            dialogStage.close();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setHeaderText("Something is wrong");
            alert.setContentText("Check data");
            alert.showAndWait();
        }
    }
}
