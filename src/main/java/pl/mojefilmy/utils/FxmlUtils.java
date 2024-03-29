package pl.mojefilmy.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.util.ResourceBundle;

public class FxmlUtils {

    public static Pane fxmlLoader(String fxmlPath) {

        FXMLLoader loader = new FXMLLoader(FxmlUtils.class.getResource(fxmlPath));
        //Locale.setDefault(new Locale("en"));
        loader.setResources(getResourceBundle());
        try {
            return loader.load();
        } catch (Exception e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        return null;
    }

    public static ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle("translation.language");
    }
}
