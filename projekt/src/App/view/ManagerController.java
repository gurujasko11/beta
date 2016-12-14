package App.view;

import App.MainApp;
import App.model.Customer;
import App.model.Offer;
import App.model.Order;
import App.model.Position;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by busz on 14.11.16.
 */
public class ManagerController {

    MainApp mainApp;
    @FXML
    private TableView<Order> OrdersTable;

    @FXML
    private TableColumn<Order, String> fstNameColumn;

    @FXML
    private TableColumn<Order,String> sndNameColumn;

    @FXML
    private TableColumn<Order, Integer> orderIDColumn;

    @FXML
    private TableView<Position> PositionsTable;

    @FXML
    private TableColumn<Position, String> posNameColumn;

    @FXML
    private TableColumn<Position, Integer> posQuantityColumn;

    @FXML
    private TableColumn<Position, Double> posPriceColumn;

    @FXML
    private TableView<Offer> OffersTable;

    @FXML
    private TableColumn<Offer, String> offerName;

    @FXML
    private TableColumn<Offer, String> offerType;

    @FXML
    private TableColumn<Offer, Double> offerPrice;

    @FXML
    private TableColumn<Offer, Double> offerTax;

    @FXML
    private Label ClientLabel;

    @FXML
    private Label DateLabel;

    @FXML
    private Label AddressLabel;

    @FXML
    private Label TotalLabel;

    //BUTTONS///////////////////////////////////////////
    @FXML
    public void handleLogout(){
        mainApp.showWelcomeLayout();
    }

    @FXML
    private void handleNewOffer() {
        //TODO
        //show new-offer window
    }

    @FXML
    private void handleEditOffer() {
        //TODO
        //show edit-offer window
    }

    @FXML
    private void handleDeleteOffer() {

        Offer off = OffersTable.getSelectionModel().getSelectedItem();
        if(off != null){
            mainApp.getOffers().remove(off);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Deleted succesfully");
            alert.setContentText("gz");
            alert.showAndWait();
        }
    }
    public ManagerController(){
    }
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        orderIDColumn.setCellValueFactory(cellData -> cellData.getValue().orderIDProperty().asObject());
        fstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getCustomer().getName());
        sndNameColumn.setCellValueFactory(cellData -> cellData.getValue().getCustomer().getSecondName());
//        customerColumn.setCellValueFactory(cellData -> cellData.getValue().);
        showOrderDetails(null);
        OrdersTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showOrderDetails(newValue));

        posNameColumn.setCellValueFactory(cellData -> cellData.getValue().getOffer().getProduct().getName());
        posQuantityColumn.setCellValueFactory(cellData -> cellData.getValue().getQuantity().asObject());
        posPriceColumn.setCellValueFactory(cellData -> cellData.getValue().getOffer().getPrice().asObject());

        offerName.setCellValueFactory(cellData -> cellData.getValue().getProduct().getName());
        offerPrice.setCellValueFactory(cellData -> cellData.getValue().getPrice().asObject());
        offerTax.setCellValueFactory(cellData -> cellData.getValue().getTax().asObject());
        offerType.setCellValueFactory(cellData -> cellData.getValue().getProduct().getTpye().getTypeName());
    }
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        OrdersTable.setItems(mainApp.getOrders());
        OffersTable.setItems(mainApp.getOffers());
    }

    private void showOrderPositions(Order ord) {
        PositionsTable.setItems(ord.getPositions());
    }

    private void showOrderDetails(Order ord) {
        if(ord != null){
            ClientLabel.setText(ord.getCustomer().getName().getValue());
            DateLabel.setText(DateUtil.format(ord.getDate().getValue()));
            AddressLabel.setText(ord.getCustomer().getAddress().getAddressAsString());
            TotalLabel.setText(ord.getTotal().getValue().toString());
            showOrderPositions(ord);
        }
        else{
            ClientLabel.setText("");
            DateLabel.setText("");
            AddressLabel.setText("");
            TotalLabel.setText("");
        }
    }
}
