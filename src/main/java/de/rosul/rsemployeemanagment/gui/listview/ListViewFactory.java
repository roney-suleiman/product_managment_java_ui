package de.rosul.rsemployeemanagment.gui.listview;

import de.rosul.rsemployeemanagment.model.Product;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * Baut die ListView
 */
public class ListViewFactory implements Callback<ListView<Product>, ListCell<Product>> {


//region Konstanten
//endregion

//region Attribute
//endregion

//region Konstruktor
//endregion

//region Methoden

    @Override
    public ListCell<Product> call(ListView<Product> productListView) {
        return new ListViewCell();
    }

//endregion

}
