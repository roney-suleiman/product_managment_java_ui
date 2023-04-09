module de.rosul.rsemployeemanagment {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.mariadb.jdbc;
    requires java.sql;

    opens de.rosul.rsemployeemanagment to javafx.fxml;
    exports de.rosul.rsemployeemanagment;
    exports de.rosul.rsemployeemanagment.gui;
    opens de.rosul.rsemployeemanagment.gui to javafx.fxml;
}