package com.example.demo;

import javafx.scene.control.Alert;
import java.sql.Connection;
import java.sql.DriverManager;

import static java.lang.Class.forName;

public class ConnectionDb {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String USERNAME = "EMLOYEE";
    private static final String PASSWORD = "admin123";

    Connection connection = null;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public Connection conMethod(){

        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            if(connection !=null) {
               // alert.setContentText("Successfully");
            }
            else {
                //alert.setContentText(" soory");
            }

        } catch (Exception e){
            alert.setContentText(e.toString());

        }
        //alert.showAndWait();
        return connection;
    }

}
