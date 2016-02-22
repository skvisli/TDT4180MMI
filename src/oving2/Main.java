package oving2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {
        launch(Main.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = (Parent)fxmlLoader.load(this.getClass().getResourceAsStream("Appointment.fxml"));
        stage.setScene(new Scene(root));
        root.getStylesheets().add("oving2/style.css");
        stage.show();
    }
}