package com.example.demo;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.Integer.parseInt;

public class addEmp {
    public static void addEmployee(){
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

        Label l6=new Label("Sex");

        ToggleGroup group=new ToggleGroup();
        RadioButton rbtn1=new RadioButton("Male");
        RadioButton rbtn2=new RadioButton("Female");
        rbtn1.setToggleGroup(group);
        rbtn2.setToggleGroup(group);

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

        l1.setLayoutY(40);
        l1.setLayoutX(150);
        Fname.setLayoutY(40);
        Fname.setLayoutX(240);
        l2.setLayoutY(70);
        l2.setLayoutX(150);
        Lname.setLayoutY(70);
        Lname.setLayoutX(240);
        l3.setLayoutY(100);
        l3.setLayoutX(150);
        Prof.setLayoutY(100);
        Prof.setLayoutX(240);

        l4.setLayoutY(130);
        l4.setLayoutX(150);
        Pos.setLayoutY(130);
        Pos.setLayoutX(240);
        l5.setLayoutY(160);
        l5.setLayoutX(150);
        Id.setLayoutY(160);
        Id.setLayoutX(240);

        l6.setLayoutY(190);
        l6.setLayoutX(150);
        rbtn1.setLayoutY(190);
        rbtn1.setLayoutX(235);
        rbtn2.setLayoutY(190);
        rbtn2.setLayoutX(285);

        age.setLayoutX(150);
        age.setLayoutY(220);
        Age.setLayoutX(240);
        Age.setLayoutY(220);
        exp.setLayoutX(150);
        exp.setLayoutY(250);
        Exp.setLayoutX(240);
        Exp.setLayoutY(250);
        submit.setLayoutX(150);
        submit.setLayoutY(280);
        returnBtn.setLayoutX(450);
        returnBtn.setLayoutY(450);
        returnBtn.setPrefSize(100,30);
        submit.setPrefSize(100,30);

        Label lb0=new Label("Add Employee Information");
        lb0.setLayoutY(10);
        lb0.setStyle("-fx-font-weight:bold;-fx-font-size:18;-fx-text-fill:#32CC99");
        lb0.setLayoutX(220);
        returnBtn.setOnAction(e->{
            Options.displayOptions();
            opt.close();


        });

        submit.setOnAction(e-> {
            Alert al=new Alert(Alert.AlertType.ERROR);
            Alert al2=new Alert(Alert.AlertType.CONFIRMATION);

            String name, fname, prof, pos, id, agee, expp;
            char sex = 'H';
            int aggee;
            name = Fname.getText();
            fname = Lname.getText();
            prof = Prof.getText();
            pos = Pos.getText();
            id = Id.getText();
            agee = Age.getText();
            expp = Exp.getText();
            if (rbtn1.isSelected()) {
                sex = 'M';
            } else if(rbtn2.isSelected()) {
                sex = 'F';
            }
            if(name==null||fname==null||prof==null||pos==null||id==null||agee==null||expp==null||sex=='H'){
                al.setContentText("Looks like You  missed a spot");
                al.show();
            }
            aggee = parseInt(agee);


                boolean status=false;
                String query = "Insert into DATA(FNAME,LNAME,EMPPROF,POSSITION,EMPID,SEX,AGE,EXPERIANCE) VALUES('" + name + "','"
                        + fname + "','" + prof + "','" + pos + "','" + id + "','" + sex + "','" + aggee + "','" + expp + "')";
                ConnectionDb db = new ConnectionDb();
                Connection connection = db.conMethod();
                Statement statement = null;
                try {
                    statement = connection.createStatement();
                } catch (SQLException ex) {
                    al.setContentText("Something went Wrong ");
                    al.show();
                }
                status = false;
                try {
                    status = statement.execute(query);
                    al2.setContentText("Successfully Inserted");


                } catch (SQLException ex) {
                    al.setContentText("Error occurred while executing");
                    al.show();
                }

            if (!status) {
                al2.setContentText("successfully inserted");
                al2.showAndWait();
            } else {
                al.setContentText("Not successfully inserted");
                al.showAndWait();
            }
            try {
                statement.close();
            } catch (SQLException ex) {
                al2.setContentText("statment not closed.sql");
                al2.show();
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                al2.setContentText("connection not closed.sql");
                al2.show();
            }
        });
        returnBtn.setStyle("-fx-background-color:#32CC99");
        submit.setStyle("-fx-background-color:#32CC99");

        Group gr=new Group();
        gr.getChildren().addAll(lb0,l1,l2,l3,l4,l5,l6,Fname,Lname,Prof,Pos,Id,rbtn1,rbtn2,age,Age,exp,Exp,submit,returnBtn);

        Scene scene=new Scene(gr,600,500);
        scene.setFill(Color.web("#e6e9f0"));
        opt.setScene(scene);
        opt.setResizable(false);
        opt.setTitle("EMS/Add employee");
        opt.show();

    }


}
