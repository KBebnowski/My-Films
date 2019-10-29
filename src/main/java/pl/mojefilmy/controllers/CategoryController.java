package pl.mojefilmy.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import pl.mojefilmy.FilmsFx.CategoryFx;
import pl.mojefilmy.FilmsFx.CategoryModel;

public class CategoryController {

    @FXML
    private Button addCategoryButton;

    @FXML
    private Button deleteCategoryButton;

    @FXML
    private TextField categoryTextField;

    @FXML
    private ComboBox<CategoryFx> categoryComboBox;

    CategoryModel categoryModel;

    public void initialize(){
        this.categoryModel = new CategoryModel();
        this.categoryModel.init();
        this.categoryComboBox.setItems(this.categoryModel.getCategoryList());
        initBindings();
    }

    private void initBindings(){
        this.addCategoryButton.disableProperty().bind(categoryTextField.textProperty().isEmpty());
        this.deleteCategoryButton.disableProperty().bind(this.categoryModel.categoryProperty().isNull());
    }

    public void addCategoryOnAction() {
        categoryModel.saveCategoryInDataBase(categoryTextField.getText());
        categoryTextField.clear();
    }

    public void onActionDeleteButton(ActionEvent actionEvent) {
        this.categoryModel.deleteCategoryById();
    }

    public void onActionComboBox(ActionEvent actionEvent) {
        this.categoryModel.setCategory(this.categoryComboBox.getSelectionModel().getSelectedItem());
    }
}
