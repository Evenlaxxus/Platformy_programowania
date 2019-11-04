package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Main extends Application {

    final Button button = new Button ("Make series");
    final Button change_button = new Button ("Change chart type");
    final TextField a = new TextField();
    final TextField b = new TextField();
    final TextField c = new TextField();

    String chart_name = "";

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
//        root.getChildren().add(createChart());
        root.getChildren().add(createGrid());
    }

    private GridPane createGrid(){
        GridPane grid = new GridPane();
        GridPane menu = new GridPane();
        menu.setVgap(4);

        menu.add(new Label("A: "), 0, 1);
        menu.add(a, 1, 1);

        menu.add(new Label("B: "), 0, 2);
        menu.add(b, 1, 2);

        menu.add(new Label("C: "), 0, 3);
        menu.add(c, 1, 3);
        menu.add(button, 0, 4);

        final ComboBox chartComboBox = new ComboBox();
        chartComboBox.getItems().addAll(
                "Line Chart",
                "Scatter Chart"
        );

        chartComboBox.setValue("Line Chart");

        chartComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                chart_name = t1;
            }
        });

        final NumberAxis xAxis = new NumberAxis();
        xAxis.setSide(Side.BOTTOM);
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setSide(Side.LEFT);
        final LineChart<Number,Number> lc = new LineChart<Number,Number>(xAxis,yAxis);
        final ScatterChart<Number,Number> sc = new ScatterChart<Number,Number>(xAxis,yAxis);

        // setup chart
        xAxis.setLabel("X");
        yAxis.setLabel("Y");
        // add starting data
        XYChart.Series<Number, Number> series1 = new XYChart.Series<Number, Number>();
        XYChart.Series<Number, Number> series2 = new XYChart.Series<Number, Number>();
        XYChart.Series<Number, Number> series3 = new XYChart.Series<Number, Number>();
        XYChart.Series<Number, Number> series4 = new XYChart.Series<Number, Number>();

        series1.setName("A");
        series2.setName("B");
        series3.setName("C");
        series3.setName("D");

        //zad1 a
        for (int i=0; i<5; i++) series1.getData().add(new XYChart.Data<Number, Number>(i, 0));

        //zad1 b
        for (int i=0; i<5; i++) series2.getData().add(new XYChart.Data<Number, Number>(i, -1*Math.pow(i,2)));

        //zad1 c
        for (int i=0; i<5; i++) series3.getData().add(new XYChart.Data<Number, Number>(i, Math.pow(i,2)-i+3));

        lc.getData().add(series1);
        sc.getData().add(series1);
        lc.getData().add(series2);
        sc.getData().add(series2);
        lc.getData().add(series3);
        sc.getData().add(series3);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (a.getText() != null && !a.getText().isEmpty()){
                    for (int i=0; i<5; i++) series4.getData().add(new XYChart.Data<Number, Number>(i, Double.parseDouble(a.getText())*Math.pow(i,2)+Double.parseDouble(b.getText())*i+Double.parseDouble(c.getText())));
                    lc.getData().add(series4);
                    sc.getData().add(series4);

                }
            }
        });

        change_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                if(chart_name=="Line Chart"){
                    grid.getChildren().remove(sc);
                    grid.add(lc, 0, 0);
                }else if(chart_name=="Scatter Chart"){
                    grid.getChildren().remove(lc);
                    grid.add(sc, 0, 0);
                }
            }
        });

        grid.add(lc, 0, 0);
        grid.add(menu, 1, 0);
        grid.add(chartComboBox, 1, 1);
        grid.add(change_button, 2, 1);

        return grid;
    }



    private LineChart<Number, Number> createChart() {
        final NumberAxis xAxis = new NumberAxis();
        xAxis.setSide(Side.BOTTOM);
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setSide(Side.LEFT);
        final LineChart<Number,Number> lc = new LineChart<Number,Number>(xAxis,yAxis);
        // setup chart
        xAxis.setLabel("X");
        yAxis.setLabel("Y");
        // add starting data
        XYChart.Series<Number, Number> series1 = new XYChart.Series<Number, Number>();
        XYChart.Series<Number, Number> series2 = new XYChart.Series<Number, Number>();
        XYChart.Series<Number, Number> series3 = new XYChart.Series<Number, Number>();
        series1.setName("A");
        series2.setName("B");
        series3.setName("C");

        //zad1 a
        for (int i=0; i<5; i++) series1.getData().add(new XYChart.Data<Number, Number>(i, 0));

        //zad1 b
        for (int i=0; i<5; i++) series2.getData().add(new XYChart.Data<Number, Number>(i, -1*Math.pow(i,2)));

        //zad1 c
        for (int i=0; i<5; i++) series3.getData().add(new XYChart.Data<Number, Number>(i, Math.pow(i,2)-i+3));

        lc.getData().add(series1);
        lc.getData().add(series2);
        lc.getData().add(series3);

        return lc;
    }

    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX
     * application. main() serves only as fallback in case the
     * application can not be launched through deployment artifacts,
     * e.g., in IDEs with limited FX support. NetBeans ignores main().
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
