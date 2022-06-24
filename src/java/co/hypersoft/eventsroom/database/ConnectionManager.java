/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.hypersoft.eventsroom.database;

import java.sql.*;

/**
 *
 * @author jdaza
 */
public class ConnectionManager {

    private Connection con;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String host = "localhost";
    private int port = 3306;
    private String database = "events_room";
    private String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true&useSSL=false";
    private String user = "jdaza";
    private String password = "4tMiC0mpany";

    public Connection getConnection() {
        try {
            Class.forName(driver);

            con = DriverManager.getConnection(url, user, password);
            System.out.println("DB Succesfully connected");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Couldn't connect to DB: " + ex);
        }
        return con;
    }

    public static void main(String[] args) {
        ConnectionManager cm = new ConnectionManager();

        cm.getConnection();
    }
}
