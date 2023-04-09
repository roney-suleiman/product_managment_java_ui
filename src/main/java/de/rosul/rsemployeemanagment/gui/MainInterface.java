package de.rosul.rsemployeemanagment.gui;

import de.rosul.rsemployeemanagment.gui.listview.ListViewFactory;
import de.rosul.rsemployeemanagment.logic.ProductHolder;
import de.rosul.rsemployeemanagment.model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Steuerlogik für die Main interface Scene
 */
public class MainInterface implements Initializable {
//region Konstanten
//endregion

//region Attribute
@FXML
    private ListView<Product> productListView;

    @FXML
    private TextField searchBar;


    @FXML
    private Button btnShowExpiredProducts;
    @FXML
    private Button btnReset;

//endregion

//region Konstruktor
    public MainInterface() {}
//endregion

//region Methoden
@FXML
    public void switchToDetailInterfaceForNewProduct() {
    InterfaceManager.getInstance().switchToDetailInterface(null);
}


    /**
     * Wird vor dem Öffnen einer Szene aufgerufen, um den Controller der
     *  Szene zu initialisieren.
     * @param url Ort um relative Pfade für das Root-Objekt aufzulösen, order null, wenn der Ort nicht bekannt ist
     * @param resourcesBundle  Resource-Bundle zum Lokalisieren des Objektes, oder null, wenn
     *                         das Objekt nicht lokalisiert ist

     */

    @Override
    public void initialize(URL url, ResourceBundle resourcesBundle) {


//        ObservableList<Product> observableProductList = FXCollections.observableList(Test.getProductData());
//        productListView.setCellFactory(new ListViewFactory());
//        productListView.setItems(observableProductList);


        productListView.setCellFactory(new ListViewFactory());
        productListView.setItems(ProductHolder.getInstance().getProduct());
        productListView.setOnMouseClicked(mouseEvent -> {
            if(mouseEvent.getClickCount() == 2 && mouseEvent.getButton() == MouseButton.PRIMARY ) {
                Product selectedProduct = productListView.getSelectionModel().getSelectedItem();
                InterfaceManager.getInstance().switchToDetailInterface(selectedProduct);
            }
        });
    }

    /**
     * ein method die kontrolliert die sort prozessen
     */
    @FXML
    private void sortProducts(ActionEvent actionEvent) {
        InterfaceManager.getInstance().switchToMainInterface();
        if(actionEvent.getSource() instanceof Button sortButtonName) {
            switch (sortButtonName.getId()) {
                case "sortByName" -> ProductHolder.getInstance().sortByName();
                case "sortByPrice" -> ProductHolder.getInstance().sortByPrice();
                case "sortByExpire" -> ProductHolder.getInstance().sortByExpiredDate();
            }
        }
    }

    @FXML
    private void showExpiredProducts() {
        productListView.setCellFactory(new ListViewFactory());
        productListView.setItems(ProductHolder.getInstance().showExpiredProducts());
    }

    @FXML
    private void getInit() {
        InterfaceManager.getInstance().switchToMainInterface();
    }

    /**
     * Sucht in die ListView (unser Products) nach die Product namen
     */
    @FXML
    private void searchName() {

        productListView.setCellFactory(new ListViewFactory());
        productListView.setItems(ProductHolder.getInstance().search(searchBar.getText()));
    }


//endregion
}