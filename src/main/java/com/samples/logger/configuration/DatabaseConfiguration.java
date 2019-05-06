package com.samples.logger.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseConfiguration {

    private Properties properties;

    public DatabaseConfiguration(Properties properties) {
        this.properties = properties;
    }

    private Connection getConnection() {
        Connection connection;
        try {
            Class.forName(properties.getProperty("logger.db.jdbc.driver"));
            String username = properties.getProperty("logger.db.username");
            String password = properties.getProperty("logger.db.password");
            connection = DriverManager.getConnection(properties.getProperty("logger.db.url"), username, password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Connection to database Error", e);
        }
        return connection;
    }

    public void createTableIfNotExists() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnection();

            if (connection.isValid(0)) {
                statement = connection.createStatement();
                statement.executeUpdate(
                        "create table IF NOT EXISTS Log(message varchar(255), type int)");

            }

        } catch (SQLException e) {
            throw new RuntimeException("Create table Error", e);
        } finally {
            try { if (statement != null) statement.close(); } catch (Exception ignored) {}
            try { if (connection != null) connection.close(); } catch (Exception ignored) {}
        }
    }

    public void insertMessage(String message, int messageType) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.execute(
                    "INSERT INTO Log(message, type) VALUES('" + message + "', " + messageType + ")");
        } catch (SQLException e) {
            throw new RuntimeException("Insert message Error", e);
        } finally {
            try { if (statement != null) statement.close(); } catch (Exception ignored) {}
            try { if (connection != null) connection.close(); } catch (Exception ignored) {}
        }
    }
}
