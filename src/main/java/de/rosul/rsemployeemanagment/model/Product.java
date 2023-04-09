package de.rosul.rsemployeemanagment.model;

import de.rosul.rsemployeemanagment.setting.AppTexts;
import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Stellt ein Produkt aus
 */
public class Product {

    //endregion

//region Attribute
    private int id;
    private final StringProperty name;
    private final DoubleProperty weight;
    private final DoubleProperty buyPrice;
    private final IntegerProperty quantity;
    private final DoubleProperty tax;
    private final DoubleProperty shippingPrice;
    private final DoubleProperty sellPrice;
    private final StringProperty expiredDate;
    private final StringProperty validity;

//endregion

//region Konstruktor

    public Product() {
        name = new SimpleStringProperty(AppTexts.STRING_INIT);
        weight = new SimpleDoubleProperty(AppTexts.DOUBLE_INIT);
        buyPrice = new SimpleDoubleProperty(AppTexts.DOUBLE_INIT);
        tax = new SimpleDoubleProperty(AppTexts.DOUBLE_INIT);
        shippingPrice = new SimpleDoubleProperty(AppTexts.DOUBLE_INIT);
        sellPrice = new SimpleDoubleProperty(AppTexts.DOUBLE_INIT);
        quantity = new SimpleIntegerProperty(AppTexts.INT_QUANTITY);
        expiredDate = new SimpleStringProperty(AppTexts.DATE_INIT);
        validity = new SimpleStringProperty(AppTexts.STRING_VALIDITY_VALUE);
    }

    public Product(String name, double weight, double buyPrice, double shippingPrice, int quantity, LocalDate expiredDate) {
        this.name = new SimpleStringProperty(name);
        this.weight = new SimpleDoubleProperty(weight);
        this.buyPrice = new SimpleDoubleProperty(buyPrice);
        this.tax = new SimpleDoubleProperty(getTax());
        this.shippingPrice = new SimpleDoubleProperty(shippingPrice);
        this.sellPrice = new SimpleDoubleProperty(getSellPrice());
        this.quantity = new SimpleIntegerProperty(quantity);
        this.expiredDate = new SimpleStringProperty(expiredDate.toString());
        this.validity = new SimpleStringProperty(getValidity());
    }

    //endregion

//region Methoden



    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getWeight() {
        return weight.get();
    }

    public DoubleProperty weightProperty() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight.set(weight);
    }

    public double getBuyPrice() {
        return buyPrice.get();
    }

    public DoubleProperty buyPriceProperty() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice.set(buyPrice);
    }

    public int getQuantity() {
        return quantity.get();
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public double getTax() {

     return (buyPrice.get() * 19) / 100;
    }

    public DoubleProperty taxProperty() {
        return tax;
    }


    public double getShippingPrice() {
        return shippingPrice.get();
    }

    public DoubleProperty shippingPriceProperty() {
        return shippingPrice;
    }

    public void setShippingPrice(double shippingPrice) {
        this.shippingPrice.set(shippingPrice);
    }

    public double getSellPrice() {
        return (buyPrice.get() + (buyPrice.get()/4) + tax.get() + shippingPrice.get());
    }

    public DoubleProperty sellPriceProperty() {
        return sellPrice;
    }

    public String getExpiredDate() {
        return expiredDate.get();
    }
    public void setExpiredDate(String expiredDate) {
        this.expiredDate.set(expiredDate);
    }

    public String getValidity() {
        if(expiredDate != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppTexts.DATE_FORMAT);
            LocalDate ld = LocalDate.parse(expiredDate.get(), formatter);
            if(ld.isBefore(LocalDate.now())) {
                return AppTexts.TEXT_EXPIRED;
            } else {
                return AppTexts.TEXT_UNEXPIRED;
            }
        }
        return validity.get();
    }

    public StringProperty validityProperty() {
        return validity;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




//endregion

}
