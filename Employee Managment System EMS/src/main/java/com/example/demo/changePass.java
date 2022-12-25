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
import java.util.Objects;

public class changePass {
    public static void pass() {

        Stage pass=new Stage();
        Label l2=new Label("Enter old Password");
        Label l3=new Label("Enter new Password");
        Label l4=new Label("Confirm new Password");
        PasswordField old=new PasswordField();
        PasswordField New=new PasswordField();
        PasswordField conf=new PasswordField();
        Button returnBtn=new Button("Return");
        Button submit=new Button("Submit");
        l2.setLayoutX(150);
        l2.setLayoutY(150);
        old.setLayoutX(280);
        old.setLayoutY(150);
        l3.setLayoutX(150);
        l3.setLayoutY(180);
        New.setLayoutX(280);
        New.setLayoutY(180);
        l4.setLayoutX(150);
        l4.setLayoutY(210);
        conf.setLayoutX(280);
        conf.setLayoutY(210);
        submit.setPrefSize(100,30);
        returnBtn.setPrefSize(100,30);
        submit.setLayoutX(150);
        submit.setLayoutY(250);
        returnBtn.setLayoutX(450);
        returnBtn.setLayoutY(450);
        New.setStyle("-fx-background-color:#a8ba9a");
        old.setStyle("-fx-background-color:#a8ba9a");
        conf.setStyle("-fx-background-color:#a8ba9a");
        submit.setOnAction(e->{
            String oldp,newp,confp;
            oldp=old.getText();
            newp=New.getText();
            confp=conf.getText();
            String s1,s2;
            s1=newp;
            s2=confp;

            if(!Objects.equals(s2, s1)){
                Alert al=new Alert(Alert.AlertType.ERROR);
                al.setContentText("new and old are not the same");
                al.showAndWait();
                Options.displayOptions();
                pass.close();

            }

                String query = "select * from ADMIN where USERNAME='admin' and PASSWORD='" + oldp + "'";

                ConnectionDb db = new ConnectionDb();
                Connection connection = db.conMethod();
                Statement stm;
                ResultSet re;
            Alert al2=new Alert(Alert.AlertType.CONFIRMATION);
            Alert al=new Alert(Alert.AlertType.ERROR);

                try {


                    stm = connection.createStatement();
                    re = stm.executeQuery(query);

                            if (re.next()) {
                            boolean status;
                            String query2 ="UPDATE ADMIN SET PASSWORD='"+newp+"'WHERE USERNAME='admin'";

                            Statement statement = null;
                            try {
                                statement = connection.createStatement();
                            } catch (SQLException ex) {
                                System.out.println("somthing is wrong here");
                            }
                            status = false;
                            try {
                                status = statement.execute(query2);
                            } catch (SQLException ex) {
                                System.out.println(query2);
                                System.out.println("somthing is wrong here tooo");
                            }
                                if (!status) {
                                    al2.setContentText("successfully changed");
                                    al2.showAndWait();
                                } else {
                                    al.setContentText("Error occurred");
                                    al.showAndWait();
                                }

                        } else {
                            al.setContentText("ERROR");
                        }
                    } catch (SQLException ex) {
                    al.setContentText("ERROR");
                    al.show();
                    }


        });

        returnBtn.setOnAction(e->{
            Options.displayOptions();
            pass.close();

        });
        returnBtn.setStyle("-fx-background-color:#32CC99");
        submit.setStyle("-fx-background-color:#32CC99");
        Label lb0=new Label("Change Password");
        lb0.setLayoutY(10);
        lb0.setStyle("-fx-font-weight:bold;-fx-font-size:18;-fx-text-fill:#32CC99");
        lb0.setLayoutX(220);

        Group gr=new Group();
        gr.getChildren().addAll(l2,l3,l4,old,New,conf,submit,returnBtn,lb0);
        Stage opt=new Stage();
        Scene scene=new Scene(gr,600,500);
        scene.setFill(Color.web("#e6e9f0"));
        pass.setScene(scene);
        pass.setTitle("EMS/Change password");
        pass.setResizable(false);
        pass.show();

    }
}
