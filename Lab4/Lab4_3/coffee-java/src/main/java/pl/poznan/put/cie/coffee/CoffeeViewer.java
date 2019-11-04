package pl.poznan.put.cie.coffee;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.math.BigDecimal;


public class CoffeeViewer extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override public void start(Stage stage) {
        Scene scene = new Scene(new Group());

        TableView<Coffee> table = new TableView<Coffee>();
        CoffeeDao dao = new CoffeeDao();

        ObservableList<Coffee> coffees = FXCollections.observableArrayList(dao.getAll());
        table.setItems(coffees);

        TableColumn<Coffee,String> cof_name = new TableColumn<Coffee,String>("COF_NAME");
        cof_name.setCellValueFactory(new PropertyValueFactory("name"));
        TableColumn<Coffee,Integer> sup_id = new TableColumn<Coffee,Integer>("SUP_ID");
        sup_id.setCellValueFactory(new PropertyValueFactory("supplierId"));
        TableColumn<Coffee,BigDecimal> price = new TableColumn<Coffee, BigDecimal>("PRICE");
        price.setCellValueFactory(new PropertyValueFactory("price"));
        TableColumn<Coffee,Integer> sales = new TableColumn<Coffee,Integer>("SALES");
        sales.setCellValueFactory(new PropertyValueFactory("sales"));
        TableColumn<Coffee,Integer> total = new TableColumn<Coffee,Integer>("TOTAL");
        total.setCellValueFactory(new PropertyValueFactory("total"));

        table.getColumns().setAll(cof_name, sup_id, price, sales, total);

        Group root = (Group)scene.getRoot();
        root.getChildren().add(table);
        stage.setScene(scene);
        stage.show();
    }
}