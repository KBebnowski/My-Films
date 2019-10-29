package pl.mojefilmy.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;

import java.util.Optional;
import java.util.ResourceBundle;

public class DialogsUtils {

    static ResourceBundle translation = FxmlUtils.getResourceBundle();

    public static void informationDialog(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(translation.getString("dialogs.aboutTittle"));
        alert.setHeaderText(translation.getString("dialogs.aboutHeader"));
        alert.setContentText(translation.getString("dialogs.aboutContent"));
        alert.showAndWait();
    }

    public static Optional<ButtonType> closeDialog(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(translation.getString("dialogs.closeTittle"));
        alert.setHeaderText(translation.getString("dialogs.closeHeader"));

        Optional<ButtonType> answer = alert.showAndWait();
        return answer;
    }

    public static void errorDialog(String error){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(translation.getString("error.tittle"));
        alert.setHeaderText(translation.getString("error.header"));

        TextArea textArea = new TextArea(error);
        alert.getDialogPane().setContent(textArea);

        alert.showAndWait();
    }
}
