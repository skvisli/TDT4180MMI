package slides;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MinimalApplication extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new BorderPane();

        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Minimal Application");
        stage.show();
    }

    public static void main(String[] args) {
        launch(MinimalApplication.class, args);
    }

}