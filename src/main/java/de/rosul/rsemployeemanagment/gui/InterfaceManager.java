package de.rosul.rsemployeemanagment.gui;

import de.rosul.rsemployeemanagment.Main;
import de.rosul.rsemployeemanagment.model.Product;
import de.rosul.rsemployeemanagment.setting.AppTexts;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Singleton, welcher zuständig für das Wechseln der Szenen ist.
 */
public class InterfaceManager {

//region Konstanten
//endregion

//region Attribute
    private static InterfaceManager instance;
    private Stage mainStage;
//endregion

//region Konstruktor
private InterfaceManager() {}
//endregion

//region Methoden

    public static synchronized InterfaceManager getInstance() {
    if(instance == null) instance = new InterfaceManager();
    return instance;
    }


    public void setMainStage(Stage stage) {
        mainStage = stage;
        mainStage.setTitle(AppTexts.STAGE_TITLE);
        switchToMainInterface();
    }

    /**
     * Lädt und wechselt zur Main interface Scene
     */
    public void switchToMainInterface() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(AppTexts.MAIN_XML_PATH));
        try {
            Scene mainScene = new Scene(fxmlLoader.load());
            sceneSwitch(mainScene);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Lädt und wechselt zur detail interface Scene
     */
    public void switchToDetailInterface(Product selectedProduct) {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(AppTexts.DETAIL_XML_PATH));
        try {
            Scene detailScene = new Scene(fxmlLoader.load());

                    DetailInterface detailInterface = fxmlLoader.getController();
                    detailInterface.setSelectedProduct(selectedProduct);


            sceneSwitch(detailScene);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sceneSwitch(Scene scene) {
        mainStage.setScene(scene);
        mainStage.show();
    }
//endregion

}












