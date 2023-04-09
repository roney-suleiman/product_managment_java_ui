package de.rosul.rsemployeemanagment;

import de.rosul.rsemployeemanagment.gui.InterfaceManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        InterfaceManager.getInstance().setMainStage(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}