
package com.educationit.java.standard.integrator.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class Database {


    private Connection cnn;

    public Database () throws SQLException  {

        try {

            Class.forName ("com.mysql.jdbc.Driver").newInstance();

        } catch (Exception e) {

            throw new SQLException (String.format ("Problems installing driver %S", e.getMessage (), e));
        }
    }

    public Connection getConexion () throws SQLException {

        String dbConnString = "jdbc:mysql://localhost/educacionit";
        String dbUser = "root";
        String dbPassword = "";

        return DriverManager.getConnection (dbConnString, dbUser, dbPassword);
    }
}