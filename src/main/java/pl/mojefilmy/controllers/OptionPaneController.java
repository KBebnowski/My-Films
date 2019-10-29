package pl.mojefilmy.controllers;


import javafx.fxml.FXML;

public class OptionPaneController {

    private MainPaneController mainPaneController;

    public void setMainPaneController(MainPaneController mainPaneController) {
        this.mainPaneController = mainPaneController;
    }

    @FXML
    public void ShowMovieList() {
        mainPaneController.setScreen("/fxml/Why.fxml");
    }

    @FXML
    public void ShowAddMovie() {
        mainPaneController.setScreen("/fxml/AddCategory.fxml");
    }


}
