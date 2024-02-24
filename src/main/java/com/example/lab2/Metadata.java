package com.example.lab2;

import java.sql.*;

public class Metadata {
    private static final String URL = "jdbc:postgresql://localhost:5432/musicstore?user=postgres&password=123";

    //3
    public static void printNameTables(String query) {
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            String columnName = metaData.getColumnName(1);
            System.out.println(columnName);
            System.out.println("----------");
            while (resultSet.next()) {
                String nameTable = resultSet.getString(1);
                System.out.println(nameTable);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printNameColumns(String query) {
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            String columnName = metaData.getColumnName(1);
            System.out.println(columnName);
            System.out.println("-----------");
            while (resultSet.next()) {
                String nameColumn = resultSet.getString(1);
                System.out.println(nameColumn);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
