package pl.mojefilmy.controllers;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.mojefilmy.utils.DialogsUtils;

import java.io.IOException;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainPaneController {

    @FXML
    BorderPane borderPane;

    @FXML
    private OptionPaneController optionPaneController;

    @FXML
    public void initialize(){
        optionPaneController.setMainPaneController(this);
    }

    public void setScreen(String FXMLpath){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(FXMLpath));
        ResourceBundle bundle = ResourceBundle.getBundle("translation.language");
        loader.setResources(bundle);
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        borderPane.setCenter(parent);
    }

    public void close() {
        Optional<ButtonType> answer = DialogsUtils.closeDialog();
        if(answer.get()==ButtonType.OK){
            Platform.exit();
            System.exit(0);
        }
    }

    public void setBrightMode() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    }

    public void SetNightMode() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
    }

    public void setAppOnTop(ActionEvent actionEvent) {
        Stage stage = (Stage) borderPane.getScene().getWindow();
        boolean value = ((CheckMenuItem) actionEvent.getSource()).selectedProperty().get();
        stage.setAlwaysOnTop(value);
    }

    public void showInformation() {
        DialogsUtils.informationDialog();
    }
}
