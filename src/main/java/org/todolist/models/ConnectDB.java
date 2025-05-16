package org.todolist.models;

// Uncomment line 3 to import all classes from java.sql.* for database operations.

//import java.sql.*;

// Alternatively, import only the necessary classes.

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;


public final class ConnectDB {

    private Connection connection;


    public ConnectDB() {
        String url ="jdbc:sqlite:userinfo.db"; // Specify your database URL
        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Connection Successful");

        } catch (SQLException e) {
            System.out.println("Error Connecting to Database");
            e.printStackTrace();

        }
    }


    public Connection getConnection() {
        return connection;
    }


    public void closeConnection() {
        try {
            if (connection != null) {
                System.out.println("Connection Closed");
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

