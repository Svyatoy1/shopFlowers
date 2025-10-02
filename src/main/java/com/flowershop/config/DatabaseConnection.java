package com.flowershop.util;

import com.flowershop.config.ApplicationProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                ApplicationProperties.DB_URL,
                ApplicationProperties.DB_USER,
                ApplicationProperties.DB_PASSWORD
        );
    }
}