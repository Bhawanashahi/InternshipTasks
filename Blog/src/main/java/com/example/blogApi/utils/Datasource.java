package com.example.blogApi.utils;

import com.example.blogApi.Settings;

import java.sql.Connection;
import java.sql.DriverManager;

public class Datasource {
    private static final String JDBC_URL = String.format("jdbc:mysql://%s:%s/%s?useSSL=false", Settings.DATABASE_HOST, Settings.DATABASE_PORT, Settings.DATABASE_NAME);

    public Connection getConnection() {
        Connection connection;
        try {
            System.out.println(JDBC_URL);
            connection = DriverManager.getConnection(JDBC_URL, Settings.DATABASE_USER, Settings.DATABASE_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database");
        }
        return connection;
    }
}
