package de.rosul.rsemployeemanagment.logic;

import de.rosul.rsemployeemanagment.logic.db.DbManager;
import de.rosul.rsemployeemanagment.model.Product;
import de.rosul.rsemployeemanagment.setting.AppTexts;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.Comparator;

/**
 * Klasse, welche alle produkten als ObservableList bereitstellt
 */
public class ProductHolder {

//region Konstanten
//endregion

//region Attribute
    private static ProductHolder instance;

    public ObservableList<Product> products;
//endregion

//region Konstruktor
    private ProductHolder() {
        products = FXCollections.observableArrayList(product ->
           new Observable[] {
                   product.nameProperty(), product.weightProperty(), product.buyPriceProperty(),
                   product.quantityProperty(), product.taxProperty(), product.shippingPriceProperty(),
                   product.sellPriceProperty(), new SimpleStringProperty(product.getExpiredDate()), product.validityProperty()
           }
        );
        products.addAll(DbManager.getInstance().readAllDataRecord());

        products.addListener((ListChangeListener<Product>) change -> {
            System.out.println(change);

            while (change.next()) {
                    if(change.wasAdded()) {
                        Product productToInsert = change.getAddedSubList().get(0);
                        DbManager.getInstance().insertDataRecord(productToInsert);
                    } else if (change.wasRemoved()) {
                        Product productToRemove = change.getRemoved().get(0);
                        DbManager.getInstance().deleteDataRecord(productToRemove);
                    } else if (change.wasUpdated()) {
                        int updatedIndex = change.getFrom();
                        Product productToUpdate = change.getList().get(updatedIndex);
                        DbManager.getInstance().updateDataRecord(productToUpdate);
                    }
            }

        });
    }
//endregion

//region Methoden
    public static synchronized ProductHolder getInstance() {
        if(instance == null) instance = new ProductHolder();
        return instance;
    }


    public ObservableList<Product> getProduct() {
        return products;
    }

    public void sortByName() {products.sort(Comparator.comparing(Product::getName));}
    public void sortByPrice() {products.sort(Comparator.comparing(Product::getBuyPrice));}
    public void sortByExpiredDate() {products.sort(Comparator.comparing(Product::getExpiredDate));}


    /**
     * die abgelaufenen produkten in listview ausgeben
     * @return
     */
    public ObservableList<Product> showExpiredProducts() {

        ObservableList<Product> expiredProducts = FXCollections.observableArrayList();
        for (Product product : products) {
            if (product.getValidity().equals(AppTexts.TEXT_EXPIRED)) {
                expiredProducts.add(product);
            }
        }
        return expiredProducts;

        }

    /**
     * ausgeben die produkt, das wir suchen (bei namen)
     * @param wordToSearch name die produkt
     */

    public ObservableList<Product> search(String wordToSearch) {
        ObservableList<Product> searchResult = FXCollections.observableArrayList();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(wordToSearch.toLowerCase())) {
                searchResult.add(product);
            }
        }
        return searchResult;
    }




//endregion

}
