package de.rosul.rsemployeemanagment.gui;

import de.rosul.rsemployeemanagment.logic.ProductHolder;
import de.rosul.rsemployeemanagment.model.Product;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

/**
 * Steuerlogik für die Detail-interface scene
 */
public class DetailInterface {

//region Konstanten
//endregion

//region Attribute
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtWeight;
    @FXML
    private TextField txtBuyPrice;
    @FXML
    private TextField txtShippingPrice;
    @FXML
    private TextField txtQuantity;
    @FXML
    private DatePicker dpExpiredDate;

    private Product selectedProduct;


//endregion

//region Konstruktor
//endregion

//region Methoden

    /**
     * Setzt das selektierte Product und füllt die Textfelder
     * mit den Werten seiner Eigenschaften
     * @param selectedProduct ausgewähltes Product
     */
    public void setSelectedProduct(Product selectedProduct) {
    this.selectedProduct = selectedProduct;
    if(selectedProduct != null) {
        txtName.setText(selectedProduct.getName());
        txtWeight.setText(String.valueOf(selectedProduct.getWeight()));
        txtBuyPrice.setText(String.valueOf(selectedProduct.getBuyPrice()));
        txtShippingPrice.setText(String.valueOf(selectedProduct.getShippingPrice()));
        txtQuantity.setText(String.valueOf(selectedProduct.getQuantity()));
        dpExpiredDate.setValue(LocalDate.parse(selectedProduct.getExpiredDate()));
    }
    }

    @FXML
    public void switchToMainInterface() {
        InterfaceManager.getInstance().switchToMainInterface();
    }

    /**
     * Speichern und bearbeiten
     */
    public void saveProduct() {
        if(selectedProduct != null) {
            if(textFieldIsNotBlankAndEmpty(txtName, selectedProduct.getName())) selectedProduct.setName(txtName.getText());
            if(textFieldIsNotBlankAndEmpty(txtWeight, String.valueOf(selectedProduct.getWeight()))) selectedProduct.setWeight(Double.parseDouble(txtWeight.getText()));
            if(textFieldIsNotBlankAndEmpty(txtBuyPrice, String.valueOf(selectedProduct.getBuyPrice()))) selectedProduct.setBuyPrice(Double.parseDouble(txtBuyPrice.getText()));
            if(textFieldIsNotBlankAndEmpty(txtShippingPrice, String.valueOf(selectedProduct.getShippingPrice()))) selectedProduct.setShippingPrice(Double.parseDouble(txtShippingPrice.getText()));
            if(textFieldIsNotBlankAndEmpty(txtQuantity, String.valueOf(selectedProduct.getQuantity()))) selectedProduct.setQuantity(Integer.parseInt(txtQuantity.getText()));
            selectedProduct.setExpiredDate(dpExpiredDate.getValue().toString());
        } else {
            Product product = new Product(
                    txtName.getText(),
                    Double.parseDouble(txtWeight.getText()),
                    Double.parseDouble(txtBuyPrice.getText()),
                    Double.parseDouble(txtShippingPrice.getText()),
                    Integer.parseInt(txtQuantity.getText()),
                    dpExpiredDate.getValue()
            );
            ProductHolder.getInstance().getProduct().add(product);
        }

            switchToMainInterface();

    }

    /**
     * löschen
     */
    public void deleteProduct() {
        if (selectedProduct != null) {
            ProductHolder.getInstance().getProduct().remove(selectedProduct);
            switchToMainInterface();
        }
    }


    public boolean textFieldIsNotBlankAndEmpty(TextField textField, String value) {
        return !textField.getText().isBlank() && !textField.getText().isEmpty() && !textField.getText().equals(value);
    }



//endregion

}
