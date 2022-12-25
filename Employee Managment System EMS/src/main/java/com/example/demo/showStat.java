package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.Integer.parseInt;

public class showStat {

    public void show() throws SQLException {
        Stage stat = new Stage();
        PieChart piechart = new PieChart();
        piechart.setData(getChartData());
        Group root = new Group();

        Button btn = new Button("Return");
        btn.setPrefSize(100, 30);
        btn.setLayoutX(480);
        btn.setLayoutY(450);
        btn.setOnAction(e -> {
            Options.displayOptions();
            stat.close();
        });
        btn.setStyle("-fx-background-color:#32CC99");
        Label lb0 = new Label("Status");
        lb0.setLayoutY(10);
        lb0.setStyle("-fx-font-weight:bold;-fx-font-size:18;-fx-text-fill:#32CC99");
        lb0.setLayoutX(220);


        root.getChildren().addAll(piechart, btn, lb0);
        Scene scene = new Scene(root, 600, 500);
        scene.setFill(Color.web("#e6e9f0"));
        stat.setScene(scene);
        stat.setTitle("EMS/statics");
        stat.setResizable(false);

        stat.show();
    }

    public ObservableList<PieChart.Data> getChartData() throws SQLException {
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        list.addAll(new PieChart.Data("Male", male()),
                new PieChart.Data("Female", female()));
        return list;
    }


    public static int male(){
        int i=0;

        Alert al = new Alert(Alert.AlertType.ERROR);
        String query = "SELECT COUNT(SEX) FROM DATA WHERE SEX= 'M'";
        ConnectionDb db = new ConnectionDb();
        Connection connection = db.conMethod();

        Statement se = null;
        try {
            se = connection.createStatement();
            try {
                ResultSet re = se.executeQuery(query);
                while (re.next()) {
                    String s1=re.getString("COUNT(SEX)");
                    i=parseInt(s1);



                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return i;

    }
    public static int female(){
        int i=0;

        Alert al = new Alert(Alert.AlertType.ERROR);
        String query = "SELECT COUNT(SEX) FROM DATA WHERE SEX= 'F'";
        ConnectionDb db = new ConnectionDb();
        Connection connection = db.conMethod();

        Statement se = null;
        try {
            se = connection.createStatement();
            try {
                ResultSet re = se.executeQuery(query);
                while (re.next()) {
                    String s1=re.getString("COUNT(SEX)");
                    i=parseInt(s1);



                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return i;

    }
}
