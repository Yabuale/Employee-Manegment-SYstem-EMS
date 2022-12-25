package com.example.demo;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class searchEmp {
    public static void search() {
        Stage opt = new Stage();

        Label l1 = new Label("Enter ID");
        TextField t1 = new TextField();
        Button b1 = new Button("Enter");
        Button b2 = new Button("Return");
        l1.setLayoutX(200);
        l1.setLayoutY(180);
        t1.setLayoutX(300);
        t1.setLayoutY(180);
        b1.setPrefSize(100, 30);
        b2.setPrefSize(100, 30);
        b1.setLayoutX(200);
        b1.setLayoutY(210);
        b2.setLayoutX(470);
        b2.setLayoutY(450);
        t1.setStyle("-fx-background-color:#a8ba9a");
        b2.setOnAction(e -> {
            Options.displayOptions();
            opt.close();
        });
        Label lb0 = new Label("Search Employee");
        lb0.setLayoutY(10);
        lb0.setStyle("-fx-font-weight:bold;-fx-font-size:18;-fx-text-fill:#32CC99");
        lb0.setLayoutX(220);
        Group gr = new Group(l1, t1, b1, b2, lb0);
        gr.getChildren().addAll();
        b1.setStyle("-fx-background-color:#32CC99");
        b2.setStyle("-fx-background-color:#32CC99");
        b1.setOnAction(e -> {
            String id;
            id = t1.getText();
            Alert al = new Alert(Alert.AlertType.ERROR);
            String usernames, passwords;
            String query = "SELECT * FROM DATA WHERE EMPID = '" + id + "'";
            ConnectionDb db = new ConnectionDb();
            Connection connection = db.conMethod();

            Statement se = null;
            try {
                se = connection.createStatement();
                try {
                    ResultSet re = se.executeQuery(query);
                    while (re.next()) {
                        String name = re.getString("FNAME");
                        String fname = re.getString("LNAME");
                        String prof = re.getString("EMPPROF");
                        String pos = re.getString("POSSITION");
                        String empid = re.getString("EMPID");
                        String sex = re.getString("SEX");
                        String age = re.getString("AGE");
                        String exp = re.getString("EXPERIANCE");
                        displayinfo(name,fname,prof,pos,empid,sex,age,exp);
                        opt.close();


                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


        });

        Scene scene = new Scene(gr, 600, 500);
        scene.setFill(Color.web("#e6e9f0"));
        opt.setScene(scene);
        opt.setResizable(false);
        opt.setTitle("EMS/Search");
        opt.show();
    }

    public static void displayinfo(String name, String fname, String prof, String pos, String impid, String sex, String age, String exp) {
        Stage opt = new Stage();

        Label l1 = new Label("Employee Info");

        Label l2 = new Label("NAME:");
        Label l3 = new Label("F-NAME:");
        Label l4 = new Label("PROFESSION:");
        Label l5 = new Label("POSITION:");
        Label l6 = new Label("ID:");
        Label l7 = new Label("SEX:");
        Label l8 = new Label("AGE:");
        Label l9 = new Label("EXPERIENCE:");


        Label l10 = new Label(name);
        Label l11 = new Label(fname);
        Label l12 = new Label(prof);
        Label l13 = new Label(pos);
        Label l14 = new Label(impid);
        Label l15 = new Label(sex);
        Label l16 = new Label(age);
        Label l17 = new Label(exp);
        l1.setLayoutX(250);
        l1.setLayoutY(30);
        l2.setLayoutX(20);
        l2.setLayoutY(60);
        l3.setLayoutX(20);
        l3.setLayoutY(90);
        l4.setLayoutX(20);
        l4.setLayoutY(120);
        l5.setLayoutX(20);
        l5.setLayoutY(150);
        l6.setLayoutX(20);
        l6.setLayoutY(180);
        l7.setLayoutX(20);
        l7.setLayoutY(210);
        l8.setLayoutX(20);
        l8.setLayoutY(240);
        l9.setLayoutX(20);
        l9.setLayoutY(270);


        l10.setLayoutX(150);
        l10.setLayoutY(60);
        l11.setLayoutX(150);
        l11.setLayoutY(90);
        l12.setLayoutX(150);
        l12.setLayoutY(120);
        l13.setLayoutX(150);
        l13.setLayoutY(150);
        l14.setLayoutX(150);
        l14.setLayoutY(180);
        l15.setLayoutX(150);
        l15.setLayoutY(210);
        l16.setLayoutX(150);
        l16.setLayoutY(240);
        l17.setLayoutX(150);
        l17.setLayoutY(270);
        l1.setStyle("-fx-font-weight:bold;-fx-font-size:18;-fx-text-fill:#32CC99");
        l2.setStyle("-fx-font-weight:bold;-fx-font-size:18");
        l3.setStyle("-fx-font-weight:bold;-fx-font-size:18;");
        l4.setStyle("-fx-font-weight:bold;-fx-font-size:18;");
        l5.setStyle("-fx-font-weight:bold;-fx-font-size:18;");
        l6.setStyle("-fx-font-weight:bold;-fx-font-size:18;");
        l7.setStyle("-fx-font-weight:bold;-fx-font-size:18;");
        l8.setStyle("-fx-font-weight:bold;-fx-font-size:18;");
        l9.setStyle("-fx-font-weight:bold;-fx-font-size:18;");
        l10.setStyle("-fx-font-weight:bold;-fx-font-size:18;");
        l11.setStyle("-fx-font-weight:bold;-fx-font-size:18;");
        l12.setStyle("-fx-font-weight:bold;-fx-font-size:18;");
        l13.setStyle("-fx-font-weight:bold;-fx-font-size:18;");
        l14.setStyle("-fx-font-weight:bold;-fx-font-size:18;");
        l15.setStyle("-fx-font-weight:bold;-fx-font-size:18;");
        l16.setStyle("-fx-font-weight:bold;-fx-font-size:18;");
        l17.setStyle("-fx-font-weight:bold;-fx-font-size:18;");


        Button btn = new Button("Return");

        btn.setPrefSize(100, 30);
        btn.setStyle("-fx-background-color:#32CC99");
        btn.setLayoutX(470);
        btn.setLayoutY(450);
        btn.setOnAction(e -> {
            Options.displayOptions();
            opt.close();
        });


        Group gr = new Group();
        gr.getChildren().addAll(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17,btn);

        Scene scene = new Scene(gr, 600, 500);
        scene.setFill(Color.web("#e6e9f0"));
        opt.setScene(scene);
        opt.setResizable(false);
        opt.setTitle("EMS/Search");
        opt.show();


    }
}
