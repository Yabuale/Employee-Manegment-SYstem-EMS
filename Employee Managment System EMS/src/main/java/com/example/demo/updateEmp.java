package com.example.demo;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class updateEmp {
    public static void update(){
        Stage opt=new Stage();
        Label l1=new Label("Enter F-Name");
        TextField Fname=new TextField();
        Label l2=new Label("Enter L-Name");
        TextField Lname=new TextField();
        Label l3=new Label("Emp Proffesion");
        TextField Prof=new TextField();
        Label l4=new Label("Possition");
        TextField Pos=new TextField();
        Label l5=new Label("Emp ID");
        TextField Id=new TextField();

        Label age=new Label("Age");
        TextField Age=new TextField();
        Label exp=new Label("Experiance");
        TextField Exp=new TextField();
        Button returnBtn=new Button("Return");
        Button submit=new Button("Submit");
        Fname.setStyle("-fx-background-color:#a8ba9a");
        Lname.setStyle("-fx-background-color:#a8ba9a");
        Prof.setStyle("-fx-background-color:#a8ba9a");
        Pos.setStyle("-fx-background-color:#a8ba9a");
        Id.setStyle("-fx-background-color:#a8ba9a");
        Age.setStyle("-fx-background-color:#a8ba9a");
        Exp.setStyle("-fx-background-color:#a8ba9a");

        l1.setLayoutY(70);
        l1.setLayoutX(150);
        Fname.setLayoutY(70);
        Fname.setLayoutX(240);
        l2.setLayoutY(100);
        l2.setLayoutX(150);
        Lname.setLayoutY(100);
        Lname.setLayoutX(240);
        l3.setLayoutY(130);
        l3.setLayoutX(150);
        Prof.setLayoutY(130);
        Prof.setLayoutX(240);
        l4.setLayoutY(160);
        l4.setLayoutX(150);
        Pos.setLayoutY(160);
        Pos.setLayoutX(240);

        l5.setLayoutY(40);
        l5.setLayoutX(150);
        Id.setLayoutY(40);
        Id.setLayoutX(240);
        age.setLayoutX(150);
        age.setLayoutY(190);
        Age.setLayoutX(240);
        Age.setLayoutY(190);
        exp.setLayoutX(150);
        exp.setLayoutY(220);
        Exp.setLayoutX(240);
        Exp.setLayoutY(220);
        submit.setLayoutX(150);
        submit.setLayoutY(250);
        returnBtn.setLayoutX(450);
        returnBtn.setLayoutY(450);
        returnBtn.setPrefSize(100,30);
        submit.setPrefSize(100,30);
        submit.setOnAction(e->{
            Alert al=new Alert(Alert.AlertType.CONFIRMATION);
            Alert al2=new Alert(Alert.AlertType.ERROR);
            String name,lname,prof,pos,id,agee,expp;
            boolean status=false;
            name=Fname.getText();
            lname=Lname.getText();
            prof=Prof.getText();
            pos=Pos.getText();
            id=Id.getText();
            agee=Age.getText();
            expp=Exp.getText();
            String query ="UPDATE DATA SET FNAME='"+name+"',LNAME='"+lname+"',EMPPROF='"+prof+"',POSSITION='"+pos+"',AGE='"+agee+"',EXPERIANCE='"+expp+"' WHERE EMPID='"+id+"'";
            System.out.println(query);
            ConnectionDb db = new ConnectionDb();
            Connection connection = db.conMethod();
            Statement statement = null;
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {

                al.setContentText("Error");
                al.show();
            }
            status = false;
            try {
                status = statement.execute(query);
            } catch (SQLException ex) {
                Alert al3=new Alert(Alert.AlertType.ERROR);
                al3.setContentText("Error");
                al3.show();
            }
            if (!status) {
                al2.setContentText("successfully Updated");
                al2.showAndWait();
            } else {
                al.setContentText("Not successful");
                al.showAndWait();
            }

            try {
                statement.close();
            } catch (SQLException ex) {
                Alert al23=new Alert(Alert.AlertType.ERROR);
                al23.setContentText("Error");
                al23.show();
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                al2.setContentText("Error");
                al2.show();
            }
        });

        Label lb0=new Label("Update Employee Information");
        lb0.setStyle("-fx-font-weight:bold;-fx-font-size:18;-fx-text-fill:#32CC99");
        lb0.setLayoutY(10);
        lb0.setLayoutX(220);
        returnBtn.setOnAction(e->{
            Options.displayOptions();
            opt.close();

        });
        returnBtn.setStyle("-fx-background-color:#32CC99");
        submit.setStyle("-fx-background-color:#32CC99");

        Group gr=new Group();
        gr.getChildren().addAll(lb0,l1,l2,l3,l4,l5,Fname,Lname,Prof,Pos,Id,age,Age,exp,Exp,submit,returnBtn);

        Scene scene=new Scene(gr,600,500);
        scene.setFill(Color.web("#e6e9f0"));
        opt.setScene(scene);
        opt.setResizable(false);
        opt.setTitle("EMS/Update Info");
        opt.show();
    }
}
