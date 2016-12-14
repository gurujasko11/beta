package App;/**
 * Created by busz on 12.11.16.
 */

import App.model.*;
import App.view.*;
import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout = new BorderPane();
    private ObservableMap<String,Account> accounts = FXCollections.observableHashMap();
    private ObservableList<Order> orders = FXCollections.observableArrayList();
    private ObservableList<Product> products = FXCollections.observableArrayList();
    private ObservableList<Offer> offers = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    public MainApp(){
        Customer c = new Person("Jan", "Pawel","jp", "2", "Dluga", "33-333", "21/37", "");
        Product pr = new Product("Kremowka", ProductType.ITEM);
        Offer of = new Offer(pr,21.37,0.21);
        accounts.put("jp2",c);
        products.add(pr);
        offers.add(of);
        Basket bs = c.getBasket();
        Position pos = new Position(of, 2);
        bs.addToBasket(pos);
        orders.add(c.goCheckOut());

        accounts.put("DBAdmin", new Account("DBAdmin", "dbadmin", AccountType.DBADMIN));
        accounts.put("Manager", new Account("Manager", "manager", AccountType.MANAGER));
        accounts.put("Supplier",new Account("Supplier", "supplier", AccountType.SUPPLIER));
        accounts.put("Accountant",new Account("Accountant", "accountant", AccountType.ACCOUNTANT));
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        initRootLayout();
        showWelcomeLayout();
    }

    private void initRootLayout() {
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
    }

    public void showWelcomeLayout(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/WelcomeLayout.fxml"));
            AnchorPane WelcomeLayout = (AnchorPane)loader.load();
            
            rootLayout.setCenter(WelcomeLayout);

            primaryStage.close();
            rootLayout.setPrefSize(WelcomeLayout.getPrefWidth(), WelcomeLayout.getPrefHeight());
            primaryStage.setTitle("Welcome");
            primaryStage.show();

            WelcomeLayoutController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean showLoginDialog(StringProperty loginString){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Login.fxml"));

            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Login");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);

            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            LoginController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setLoginString(loginString);
            controller.setMainApp(this);

            dialogStage.showAndWait();

            return controller.isLogInClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public void showRegisterLayout(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CreateAccount.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Register");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);

            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            CreateAccountController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainApp(this);

            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showClientLayout(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Clients.fxml"));
            AnchorPane clientsLayout = (AnchorPane)loader.load();
            rootLayout.setCenter(clientsLayout);

            primaryStage.close();
            rootLayout.setPrefSize(clientsLayout.getPrefWidth(), clientsLayout.getPrefHeight());
            primaryStage.setTitle("Clients");
            primaryStage.show();

            ClientsController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showManagerLayout(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Manager.fxml"));
            TabPane managerLayout = (TabPane) loader.load();
            rootLayout.setCenter(managerLayout);

            primaryStage.close();
            rootLayout.setPrefSize(managerLayout.getPrefWidth(), managerLayout.getPrefHeight());
            primaryStage.setTitle("Manager");
            primaryStage.show();

            ManagerController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSupplierLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Supplier.fxml"));
            TabPane supplierLayout = (TabPane) loader.load();
            rootLayout.setCenter(supplierLayout);

            primaryStage.close();
            rootLayout.setPrefSize(supplierLayout.getPrefWidth(), supplierLayout.getPrefHeight());
            primaryStage.setTitle("Supplier");
            primaryStage.show();

            SupplierController controller = loader.getController();
            controller.setMainApp(this);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void showClientOffersLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ClientOffers.fxml"));
            AnchorPane clientOffersLayout = (AnchorPane) loader.load();
            rootLayout.setCenter(clientOffersLayout);

            primaryStage.close();
            rootLayout.setPrefSize(clientOffersLayout.getPrefWidth(), clientOffersLayout.getPrefHeight());
            primaryStage.setTitle("View Offers");
            primaryStage.show();

            ClientOffersController controller = loader.getController();
            controller.setMainApp(this);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage(){
        return primaryStage;
    }

    public ObservableMap<String,Account> getAccounts() {
        return accounts;
    }
    public ObservableList<Offer> getOffers() { return offers; }
    public ObservableList<Order> getOrders() { return orders; }
    public void showAccountantLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Accountant.fxml"));
            AnchorPane accountantLayout = (AnchorPane) loader.load();
            rootLayout.setCenter(accountantLayout);

            primaryStage.close();
            rootLayout.setPrefSize(accountantLayout.getPrefWidth(), accountantLayout.getPrefHeight());
            primaryStage.setTitle("Accountant");
            primaryStage.show();

            AccountantController controller = loader.getController();
            controller.setMainApp(this);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
