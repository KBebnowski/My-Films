/*
* Maven project on JavaFx with database h2 (all java database code download from internet)
* The application has been translated (internationalization) UTF 8
* The MVC (Model-View-Controller) design pattern was used
* A jar file was built
* JavaFX Dialogs have been created with https://code.makery.ch/blog/javafx-dialogs-official/
* App can change css style
* Main purpose this app is that we can saved movies to database and delete them from it
* Created by Kamil Bębnowski 25.10.2019r.
 */



package pl.mojefilmy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.mojefilmy.database.dbutils.DbManager;

import java.util.ResourceBundle;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        //Locale.setDefault(new Locale ("en"));

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainPane.fxml"));

        ResourceBundle bundle = ResourceBundle.getBundle("translation.language");
        loader.setResources(bundle);

        BorderPane borderPane = loader.load();
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle(bundle.getString("Tittle"));
        primaryStage.show();

        DbManager.initDatabase();
    }
}
