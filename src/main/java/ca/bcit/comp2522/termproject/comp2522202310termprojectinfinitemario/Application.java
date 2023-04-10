package ca.bcit.comp2522.termproject.comp2522202310termprojectinfinitemario;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Application class.
 * @author Elijah Fabon
 * @version 1.0
 */
public class Application extends javafx.application.Application {
    @Override
    public void start(final Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getRoot().requestFocus();
        stage.setTitle("Endless Jump-Run ");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(final String[] args) {
        launch();
    }
}
