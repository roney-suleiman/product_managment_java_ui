package de.rosul.rsemployeemanagment.gui.listview;

import de.rosul.rsemployeemanagment.model.Product;
import de.rosul.rsemployeemanagment.setting.AppTexts;
import javafx.scene.control.ListCell;

/**
 * Definiert eine Zelle, wie sie in der ListView
 * angezeigt werden soll.
 */
public class ListViewCell extends ListCell<Product> {

//region Konstanten
//endregion

//region Attribute
//endregion

//region Konstruktor
//endregion

//region Methoden

    /**
     * Aktualisiert den Inhalt einer Zelle und zeigt ihn
     * auf die implementierte Art und Weise an
     * @param productToShow  DAs anzuzeigende Product
     * @param isEmpty boolyan: gibt an, ob die zelle leer ist oder nicht
     */
    @Override
    protected void updateItem(Product productToShow, boolean isEmpty) {
        super.updateItem(productToShow, isEmpty);
        if(isEmpty && productToShow == null) {
            setText(null);
            setGraphic(null);
        } else {
            setText(String.format(AppTexts.PRODUCT_FORMAT_STRING, productToShow.getName(),productToShow.getWeight(),productToShow.getBuyPrice(),productToShow.getQuantity(),productToShow.getTax(),productToShow.getShippingPrice(),productToShow.getSellPrice(),productToShow.getExpiredDate(), productToShow.getValidity()));
//              setText(String.format(productToShow.getName(),productToShow.getWeight(),productToShow.getBuyPrice(),productToShow.getQuantity(),productToShow.getTax(),productToShow.getShippingPrice(),productToShow.getSellPrice(),productToShow.getBuyDate(),productToShow.getExpiredDate()));
        }
    }

//endregion

}
