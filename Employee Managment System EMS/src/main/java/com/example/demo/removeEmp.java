package com.example.demo;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.*;

public class removeEmp {
    public static void remove(){
        Stage opt=new Stage();

        Label l1=new Label("Enter ID");
        TextField t1=new TextField();
        Button b1=new Button("Enter");
        Button b2=new Button("Return");
        l1.setLayoutX(200);
        l1.setLayoutY(180);
        t1.setLayoutX(300);
        t1.setLayoutY(180);
        b1.setPrefSize(100,30);
        b2.setPrefSize(100,30);
        b1.setLayoutX(200);
        b1.setLayoutY(210);
        b2.setLayoutX(470);
        b2.setLayoutY(450);
        b2.setStyle("-fx-background-color:#32CC99");
        b1.setStyle("-fx-background-color:#32CC99");
        t1.setStyle("-fx-background-color:#a8ba9a");
        b2.setOnAction(e->{
            Options.displayOptions();
            opt.close();
        });


        Label lb0=new Label("Remove Employee");
        lb0.setLayoutY(10);
        lb0.setStyle("-fx-font-weight:bold;-fx-font-size:18;-fx-text-fill:#32CC99");
        lb0.setLayoutX(220);
        b1.setOnAction(e->{
            String s1=t1.getText();
            boolean status=false;
            String query ="DELETE FROM DATA WHERE EMPID='"+s1+"'";
            ConnectionDb db = new ConnectionDb();
            Connection connection = db.conMethod();
            Statement statement = null;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                Alert al=new Alert(Alert.AlertType.ERROR);
                al.setContentText("Error");
                al.show();
            }
            status = false;
            try {
                status = statement.execute(query);
            } catch (SQLException ex) {
                Alert al=new Alert(Alert.AlertType.ERROR);
                al.setContentText("Error");
                al.show();
            }
            Alert al = new Alert(Alert.AlertType.INFORMATION);
            if (!status) {
                al.setContentText("successfully removed");
                al.showAndWait();
            } else {
                al.setContentText("Not successful");
                al.showAndWait();
            }
            try {
                statement.close();
            } catch (SQLException ex) {
                al.setContentText("ERR");
                al.show();
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                al.setContentText("ERROR");
                al.show();

            }


        });

        Group gr=new Group(l1,t1,b1,b2,lb0);
        gr.getChildren().addAll();

        Scene scene=new Scene(gr,600,500);
        scene.setFill(Color.web("#e6e9f0"));
        opt.setScene(scene);
        opt.setResizable(false);
        opt.setTitle("EMS/Remove");
        opt.show();

    }

}
