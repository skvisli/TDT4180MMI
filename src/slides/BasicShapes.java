package slides;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BasicShapes extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();

        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Basic Shapes");
        stage.show();

        TextField textfield = new TextField("top");
        root.setTop(textfield);
        root.setCenter(new TextArea("Hei dette er et stort tekstfelt"));
        root.setBottom(new Text("bottom"));
        root.setLeft(new Text("Left"));
        root.setRight(new Text("Right"));

        Pane shapesPane = new Pane();
        shapesPane.setPrefSize(300, 300);

        //Linje
        Line line = new Line(10, 10, 100, 100);
        line.getStrokeDashArray().setAll(10.0d, 10.0d);

        //Rektangel
        Rectangle rect = new Rectangle(150, 20, 50, 50);//
        rect.setFill(Color.BLUE);

        //Ellipse
        Ellipse ell = new Ellipse(100, 200, 40, 30);
        ell.setFill(Color.BLUE);
        ell.setStroke(Color.GREEN);
        ell.setStrokeWidth(5);

        shapesPane.getChildren().addAll(line, rect, ell);
    }

    public static void main(String[] args) {
        launch(BasicShapes.class, args);
    }

}