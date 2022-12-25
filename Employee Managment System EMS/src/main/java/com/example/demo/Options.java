package com.example.demo;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Options {
    public static void displayOptions(){
        Stage optWindow=new Stage();
        Label l1=new Label("Welcome Select Your Options");
        Button Add=new Button("Add Employee");
        Button Remove=new Button("Remove Employee");
        Button Search=new Button("Search Employee");
        Button Update=new Button("Update Employee Info");
        Button Stat=new Button("Show statics ");
        Button Pass=new Button("Change Password");
        Add.setStyle("-fx-background-color:#32CC99");
        Remove.setStyle("-fx-background-color:#32CC99");
        Search.setStyle("-fx-background-color:#32CC99");
        Update.setStyle("-fx-background-color:#32CC99");
        Stat.setStyle("-fx-background-color:#32CC99");
        Pass.setStyle("-fx-background-color:#32CC99");
        l1.setStyle("-fx-font-weight:bold;-fx-font-size:18;-fx-text-fill:#32CC99");
        Add.setPrefSize(150,40);
        Remove.setPrefSize(150,40);
        Update.setPrefSize(150,40);
        Search.setPrefSize(150,40);
        Stat.setPrefSize(150,40);
        Pass.setPrefSize(150,40);
        l1.setLayoutX(240);
        l1.setLayoutY(40);
        Add.setLayoutX(240);
        Add.setLayoutY(80);
        Remove.setLayoutX(240);
        Remove.setLayoutY(130);
        Search.setLayoutX(240);
        Search.setLayoutY(180);
        Update.setLayoutX(240);
        Update.setLayoutY(230);
        Stat.setLayoutX(240);
        Stat.setLayoutY(280);
        Pass.setLayoutX(240);
        Pass.setLayoutY(330);
        Add.setOnAction(e->{
            addEmp.addEmployee();
            optWindow.close();
        });
        Remove.setOnAction(e->{
            removeEmp.remove();
            optWindow.close();
        });
        Search.setOnAction((e->{
            searchEmp.search();
            optWindow.close();
        }));
        Update.setOnAction(e->{
            updateEmp.update();
            optWindow.close();
        });
        Stat.setOnAction(e->{
            showStat obj=new showStat();
            try {
                obj.show();
            } catch (SQLException ex) {
                Alert al=new Alert(Alert.AlertType.ERROR);
                al.setContentText("Error");
                al.show();
            }
            optWindow.close();
        });
        Pass.setOnAction(e->{
            changePass.pass();
            optWindow.close();

        });


        Group gr=new Group();
        gr.getChildren().addAll(l1,Add,Remove,Search,Update,Stat,Pass);

        Scene scene=new Scene(gr,600,500);
        scene.setFill(Color.web("#e6e9f0"));
        optWindow.setResizable(false);
        optWindow.setTitle("Ems/Home");
        optWindow.setScene(scene);

        optWindow.show();
    }
}
