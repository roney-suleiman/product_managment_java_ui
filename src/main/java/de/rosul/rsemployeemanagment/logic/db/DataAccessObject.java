package de.rosul.rsemployeemanagment.logic.db;

import java.sql.Connection;
import java.util.List;

/**
 * Methoden für CRUD-Operationen vordefiniert.
 *  DAO - Data Access Object
 * @param <T>
 */
public interface DataAccessObject<T> {
    /**
     * Methode zum Einfügen eines Objektes in die Datenbank
     * @param dbConnection  Verbindung zur Datenbank
     * @param object  Zu erstellendes Objekt einer bestimmten Klasse
     */
    void add(Connection dbConnection, T object);

    /**
     * Methode zum Auslesen alles Objekte aus der Datenbank
     * @param dbConnection  Verbindung zur Datenbank
     * @return {@link List<T>} Liste von Objekten aus der Datenbank
     *
     */
    List<T> readAll (Connection dbConnection);

    /**
     * Methode zum Löschen eines bestimmten Objektes aus der Datenbank
     * @param dbConnection Verbindung zur Datenbank
     * @param : T : objectZu löschendes Objekt einer bestimmten Klasse
     */
    void delete(Connection dbConnection, T object);

    /**
     * Methode zum Aktualisieren eines bestimmten Objektes in der Datenbank
     * @param dbConnection Verbindung zur Datenbank
     * @param object Zu erstellendes Objekt einer bestimmten Klasse
     */
    void update(Connection dbConnection, T object);

    /**
     * Methode zum Auslesen alles Objekte aus der Datenbank wen die produkt abgelaufen ist
     * @param dbConnection  Verbindung zur Datenbank
     * @return {@link List<T>} Liste von Objekten aus der Datenbank
     */
//    List<T> readAllExpire (Connection dbConnection);

}
