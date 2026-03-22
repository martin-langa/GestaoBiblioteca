package com.gestao_livraria.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {

    private static final String URL  = "jdbc:postgresql://localhost:5432/biblioteca_db";
    private static final String username = "";
    private static final String password = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, username, password);
    }
}
