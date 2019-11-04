package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ComboBoxSample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    final Button button = new Button ("Load");
    final TextField a = new TextField("");
    final TextField b = new TextField("");
    final TextField c = new TextField("");


    @Override public void start(Stage stage) {
        stage.setTitle("ComboBoxSample");
        Scene scene = new Scene(new Group(), 450, 250);

        GridPane grid = new GridPane();
        grid.setVgap(4);

        grid.add(new Label("A: "), 0, 1);
        grid.add(a, 1, 1);

        grid.add(new Label("B: "), 0, 2);
        grid.add(b, 1, 2);

        grid.add(new Label("C: "), 0, 3);
        grid.add(c, 1, 3);
        grid.add(button, 0, 4);
        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }
}