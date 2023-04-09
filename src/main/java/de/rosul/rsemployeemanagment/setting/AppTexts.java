package de.rosul.rsemployeemanagment.setting;

/**
 * Stellt alle Programmtexte als Konstanten zur Verfügung
 */
public class AppTexts {
    //region Konstanten
    public static final String STRING_INIT = "name";
    public static final String STRING_VALIDITY_VALUE = "UnExpired";
    public static final int INT_QUANTITY = 1 ;
    public static final double DOUBLE_INIT = 1;
    public static final String DATE_INIT = "01/01/2022";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String TEXT_EXPIRED = "Expired";
    public static final String TEXT_UNEXPIRED = "UnExpired";
    //region Konstanten
        public static final String SERVER_IP = "localhost";
    public static final String DB_NAME = "product_management";
    public static final String CONNECTION_URL = "jdbc:mariadb://" + SERVER_IP + "/" + DB_NAME;
    public static final String DB_USER_NAME = "root";
    public static final String DB_USER_PASSWORD = "";
    public static final String SQL_STATEMENT_INSERT_PRODUCT = "INSERT INTO products (name, weight, buyPrice, quantity, tax, shippingPrice, sellPrice, expireDate, validity) VALUES (?,?,?,?,?,?,?,?,?)";
    public static final String SQL_STATEMENT_SELECT_ALL_PRODUCT = "SELECT * FROM products";
    public static final String COL_NAME = "name";
    public static final String COL_WEIGHT = "weight";
    public static final String COL_BUY_PRICE = "buyPrice";
    public static final String COL_QUANTITY = "quantity";
    public static final String COL_SHIPPING_PRICE = "shippingPrice";
    public static final String COL_EXPIRE_DATE = "expireDate";
    public static final String COL_ID = "pk_id";
    public static final String SQL_STATEMENT_DELETE = "DELETE FROM products WHERE ?";
    public static final String SQL_STATEMENT_UPDATE = "UPDATE products SET name = ?, weight = ?, buyPrice = ?, quantity = ?, tax = ?, shippingPrice = ?, sellPrice = ?, expireDate = ?, validity = ? WHERE pk_id = ? ";
    public static final String STAGE_TITLE = "Product Management";
    public static final String MAIN_XML_PATH = "fxml/main_interface.fxml";
    public static final String DETAIL_XML_PATH = "fxml/detail_interface.fxml";
    public static final String PRODUCT_FORMAT_STRING = "%10s%15f%15f%15d%15f%15f%15f%15s%20s";

//region Konstanten

//endregion

//region Attribute
//endregion

//region Konstruktor
//endregion

//region Methoden
//endregion

}
