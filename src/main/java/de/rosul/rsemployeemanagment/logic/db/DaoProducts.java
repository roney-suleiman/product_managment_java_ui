package de.rosul.rsemployeemanagment.logic.db;

import de.rosul.rsemployeemanagment.model.Product;
import de.rosul.rsemployeemanagment.setting.AppTexts;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *  Data Access Objekt für Produkten.
 *  Stellt Methoden zur Verfügung zum Erstellen, Auslesen,
 *  Bearbeiten, Löschen von Produkten in/aus der Datenbank.
 */
public class DaoProducts implements DataAccessObject<Product> {


    //region Konstanten
    public final String TBL_NAME = "products";

//endregion

//region Attribute
//endregion

//region Konstruktor
//endregion

//region Methoden

    /**
     * erstellen
     */
    @Override
    public void add(Connection dbConnection, Product product) {
        PreparedStatement statement = null;
        try {
            statement = dbConnection.prepareStatement(
                    AppTexts.SQL_STATEMENT_INSERT_PRODUCT,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getWeight());
            statement.setDouble(3, product.getBuyPrice());
            statement.setInt(4, product.getQuantity());
            statement.setDouble(5, product.getTax());
            statement.setDouble(6, product.getShippingPrice());
            statement.setDouble(7, product.getSellPrice());
            statement.setDate(8, Date.valueOf(product.getExpiredDate()));
            statement.setString(9, product.getValidity());

            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            int insertId;
            if(resultSet.next()) {
                insertId = resultSet.getInt("insert_id");
                product.setId(insertId);
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(statement != null) statement.close();
                dbConnection.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Alle auslesen
     */
    @Override
    public List<Product> readAll(Connection dbConnection) {
        List<Product> products = new ArrayList<>();

        Statement statement = null;
        try {
            statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(AppTexts.SQL_STATEMENT_SELECT_ALL_PRODUCT);

            while (resultSet.next()) {
                Product product = new Product(
                        resultSet.getString(AppTexts.COL_NAME),
                        resultSet.getDouble(AppTexts.COL_WEIGHT),
                        resultSet.getDouble(AppTexts.COL_BUY_PRICE),
                        resultSet.getInt(AppTexts.COL_QUANTITY),
                        resultSet.getInt(AppTexts.COL_SHIPPING_PRICE),
                        LocalDate.parse(resultSet.getString(AppTexts.COL_EXPIRE_DATE))
                );
                product.setId(resultSet.getInt(AppTexts.COL_ID));
                products.add(product);
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(statement != null) statement.close();
                dbConnection.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        return products;
    }

    /**
     * löschen
     */
    @Override
    public void delete(Connection dbConnection, Product product) {
        PreparedStatement statement = null;
        try {
            statement = dbConnection.prepareStatement(AppTexts.SQL_STATEMENT_DELETE);
            statement.setInt(1, product.getId());

            statement.execute();

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(statement != null) statement.close();
                dbConnection.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Bearbeiten
     */
    @Override
    public void update(Connection dbConnection, Product product) {
        PreparedStatement statement = null;
        try {
            statement = dbConnection.prepareStatement(AppTexts.SQL_STATEMENT_UPDATE);
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getWeight());
            statement.setDouble(3, product.getBuyPrice());
            statement.setInt(4, product.getQuantity());
            statement.setDouble(5, product.getTax());
            statement.setDouble(6, product.getShippingPrice());
            statement.setDouble(7, product.getSellPrice());
            statement.setDate(8, Date.valueOf(product.getExpiredDate()));
            statement.setString(9, product.getValidity());
            statement.setInt(10, product.getId());

            statement.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(statement != null) statement.close();
                dbConnection.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * die abgelaufenen produkten auslesen
     */
//    @Override
//    public List<Product> readAllExpire(Connection dbConnection) {
//        List<Product> products = new ArrayList<>();
//
//        Statement statement = null;
//        try {
//            statement = dbConnection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM products WHERE validity = 'Expired'");
//
//            while (resultSet.next()) {
//                Product product = new Product(
//                        resultSet.getString("name"),
//                        resultSet.getDouble("weight"),
//                        resultSet.getDouble("buyPrice"),
//                        resultSet.getInt("quantity"),
//                        resultSet.getInt("shippingPrice"),
//                        LocalDate.parse(resultSet.getString("expireDate"))
//                );
//                product.setId(resultSet.getInt("pk_id"));
//                products.add(product);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (statement != null) statement.close();
//                dbConnection.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return products;
//    }
    //endregion

}
