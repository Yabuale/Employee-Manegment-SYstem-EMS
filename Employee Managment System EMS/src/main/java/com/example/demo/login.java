package com.example.demo;



import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class login  {
    public static void display(){
        Stage loginWindow=new Stage();

        Button Submit=new Button("Submit");
        Button Info=new Button("About?");
        Label user_id=new Label("Username");
        Label password = new Label("Password");
        TextField tf1=new TextField();
        PasswordField tf2=new PasswordField();
        Submit.setPrefSize(100,30);
        Info.setPrefSize(100,30);
        user_id.setStyle(" -fx-font-size:20;-fx-text-fill:#3e363f;");
        password.setStyle(" -fx-font-size:20;-fx-text-fill:#3e363f;");
        tf1.setStyle("-fx-background-color:#a8ba9a");
        tf2.setStyle("-fx-background-color:#a8ba9a");


        user_id.setLayoutX(50);
        user_id.setLayoutY(50);
        tf1.setLayoutX(150);
        tf1.setLayoutY(50);
        password.setLayoutX(50);
        password.setLayoutY(80);
        tf2.setLayoutX(150);
        tf2.setLayoutY(80);
        Submit.setStyle("-fx-background-color:#32CC99");
        Info.setStyle("-fx-background-color:#32CC99");

        Submit.setLayoutX(150);
        Submit.setLayoutY(110);

        Info.setLayoutX(150);
        Info.setLayoutY(150);
        Group gr=new Group();
        Label lb0=new Label("E.M.S");
        lb0.setLayoutY(10);
        lb0.setStyle("-fx-font-weight:bold;-fx-font-size:22;-fx-text-fill:#32CC99");
        lb0.setLayoutX(150);
        gr.getChildren().addAll(user_id,tf1,password,tf2,Submit,Info,lb0);
        Info.setOnAction(e->{
           information();
           loginWindow.close();

        });
        Submit.setOnAction(e->{
            Alert al=new Alert(Alert.AlertType.ERROR);
            String usernames,passwords;
            usernames=tf1.getText();
            passwords=tf2.getText();
            String query = "select * from ADMIN where USERNAME='"+usernames+"' and PASSWORD='"+passwords+"'";
            ConnectionDb db = new ConnectionDb();
            Connection connection = db.conMethod();
            Statement stm;
            ResultSet re;
            try {
                stm=connection.createStatement();
                re= stm.executeQuery(query);
                try {
                    if(re.next()){
                        Options.displayOptions();
                        loginWindow.close();
                    }
                    else{
                        al.setContentText("Check username or password and try again");
                        al.show();
                    }
                } catch (SQLException ex) {
                    al.setContentText("Check username or password and try again");
                    al.show();
                }
            } catch (SQLException ex) {
                al.setContentText("ERR IN DATABASE");
                al.show();
            }

        });


        Scene scene=new Scene(gr,400,300);
        scene.setFill(Color.web("#e6e9f0"));



         loginWindow.setScene(scene);
         loginWindow.setTitle("EMS/Login");
         loginWindow.setResizable(false);
         loginWindow.show();


    }
    public static void information(){
        Stage infowindow=new Stage();
        Label l1=new Label("WELCOME TO EMS");
        Label l2=new Label("Ems is a system that helps your company manage employee info");
        Label l3=new Label("If you are new read README.txt to get the default username and password you can change it after");
        Label l4=new Label("If you have any question feel free to contact us @yeabsraalebacew9@gmail.com,yenesewsileshi@gmail.com");
        l1.setStyle("-fx-font-weight:bold;-fx-font-size:18;-fx-text-fill:#32CC99");
        l1.setLayoutY(5);
        l1.setLayoutX(10);
        l2.setLayoutY(30);
        l2.setLayoutX(10);
        l3.setLayoutY(45);
        l3.setLayoutX(10);
        l4.setLayoutY(65);
        l4.setLayoutX(10);

        Stage loginWindow=new Stage();
        Button btn=new Button("Return");
        btn.setStyle("-fx-background-color:#32CC99");

        btn.setLayoutY(210);
        btn.setLayoutX(530);
        btn.setOnAction(e->{
            display();
            infowindow.close();
        });

        Group gr=new Group();
        gr.getChildren().addAll(l1,l2,l3,l4,btn);
        Scene scene=new Scene(gr,600,250);
        scene.setFill(Color.web("#e6e9f0"));
        infowindow.setScene(scene);
        infowindow.setResizable(false);
        infowindow.setTitle("EMS/Info");
        infowindow.show();



    }

}

