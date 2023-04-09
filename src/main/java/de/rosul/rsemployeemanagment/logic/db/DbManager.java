package de.rosul.rsemployeemanagment.logic.db;

import de.rosul.rsemployeemanagment.model.Product;
import de.rosul.rsemployeemanagment.setting.AppTexts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

/**
 * Baut Verbindungen zu Datenbanken auf
 * und stellt die jeweiligen Dao-Objekte Bereit um
 * auf einzelne Tabellen zuzugreifen
 */
public class DbManager {

//endregion

//region Attribute
    private static DbManager instance;
    private final DaoProducts daoProducts;
//endregion

//region Konstruktor
    private DbManager() {
        daoProducts = new DaoProducts();
    }
//endregion

//region Methoden

    public static synchronized DbManager getInstance() {
        if(instance == null) instance = new DbManager();
        return instance;
    }

    /**
     * Baut eine Verbindung zur Datenbank auf und
     * gibt diese zurück
     * @return
     */
    private Connection getConnection() {
        Connection dbConnection = null;
        try {
            dbConnection = DriverManager.getConnection(AppTexts.CONNECTION_URL, AppTexts.DB_USER_NAME, AppTexts.DB_USER_PASSWORD);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return dbConnection;
    }


    /**
     * Leitet das Einfügen eines Datensatzes für das übergebene Objekt ein.
     * Dafür wird geprüft, um welche Instanz es sich genau handelt.
     * @param object
     */
    public void insertDataRecord(Object object) {
        if(object instanceof Product product) daoProducts.add(getConnection(), product);
    }

    /**
     * Liest alle Tiere aus der Datenbank aus und gibt
     * sie als Liste zurück
     * @return
     */
    public List<Product> readAllDataRecord() {
        return daoProducts.readAll(getConnection());
    }

    /**
     * Leitet das Aktualisieren eines Datensatzes für das übergebene Objekt ein.
     * Dafür wird geprüft, um welche Instanz es sich genau handelt.
     * @param object
     */
    public void updateDataRecord(Object object) {
        if(object instanceof Product product) daoProducts.update(getConnection(), product);
    }

    /**
     * Leitet das Löschen eines Datensatzes für das übergebene Objekt ein.
     * Dafür wird geprüft, um welche Instanz es sich genau handelt.
     */
    public void deleteDataRecord(Object object) {
        if(object instanceof Product product) daoProducts.delete(getConnection(), product);
    }

//    public List<Product> readAllExpiredDataRecord() {
//        return daoProducts.readAllExpire(getConnection());
//    }



//endregion

}
