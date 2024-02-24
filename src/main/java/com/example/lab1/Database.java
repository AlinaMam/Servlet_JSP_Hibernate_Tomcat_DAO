package com.example.lab1;

import java.sql.*;

public class Database {
    private static final String DB = "musicstoreOld";
    private static final String URL = "jdbc:postgresql://localhost:5432/musicstore?user=postgres&password=123";
    public static final String CREATE_TABLE1 = "CREATE TABLE artist ("
            + "id SERIAL,"
            + "name VARCHAR(50) NOT NULL,"
            + "surname VARCHAR(100) NOT NULL,"
            + "PRIMARY KEY(id)"
            + ");";
    public static final String CREATE_TABLE2 = "CREATE TABLE album ("
            + "id SERIAL,"
            + "name VARCHAR(50) NOT NULL,"
            + "genre VARCHAR(50) NOT NULL,"
            + "id_artist INT NOT NULL,"
            + "PRIMARY KEY(id),"
            + "FOREIGN KEY(id_artist) REFERENCES artist(id)"
            + ");";
    public static final String CREATE_TABLE3 = "CREATE TABLE composition ("
            + "id SERIAL,"
            + "name VARCHAR(50) NOT NULL,"
            + "duration NUMERIC(4,2) NOT NULL,"
            + "id_album INT,"
            + "id_artist INT NOT NULL,"
            + "PRIMARY KEY(id),"
            + "FOREIGN KEY(id_album) REFERENCES album(id)"
            + ");";
    public static final String IN_ARTISTS = "INSERT INTO artist (name, surname) VALUES (?, ?);";
    public static final String IN_ALBUM = "INSERT INTO album(id_artist, name, genre) VALUES (?, ?, ?);";
    public static final String IN_COMPOSITION = "INSERT INTO composition(id_album, name, duration) VALUES (?, ?, ?);";

    public static void createTable(String query) {
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertInArtists(String name, String surname) {
        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement preparedStatement = connection.prepareStatement(IN_ARTISTS)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertInAlbum(int num, String name, String genre) {
        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement preparedStatement = connection.prepareStatement(IN_ALBUM)) {
            preparedStatement.setInt(1, num);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, genre);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertInComposition(int num, String name, double duration) {
        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement preparedStatement = connection.prepareStatement(IN_COMPOSITION)) {

            preparedStatement.setInt(1, num);
            preparedStatement.setString(2, name);
            preparedStatement.setDouble(3, duration);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void doQuery1(String query) {
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metadata = resultSet.getMetaData();
            System.out.println(metadata.getColumnName(1));
            System.out.println("------------");
            while (resultSet.next()) {
                String data = resultSet.getString(1);
                System.out.println(data);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void doQuery2(String query) {
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            System.out.printf("%-10s%s%n", "name", "duration");
            System.out.println("------------------");
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                double duration = resultSet.getDouble(2);
                System.out.printf("%-10s%.2f%n", name, duration);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void doQuery3(String query) {
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metadata = resultSet.getMetaData();
            String columnName = metadata.getColumnName(1);
            System.out.println(columnName);
            System.out.println("-------");
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                System.out.println(name);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void doQuery4(String query) {
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            System.out.printf("%-10s%-10s%-10s%-10s%s%n", "minDur", "maxDur", "avgDur", "sumDur", "countCompositions");
            System.out.println("---------------------------------------------------------");
            while (resultSet.next()) {
                double minDur = resultSet.getDouble(1);
                double maxDur = resultSet.getDouble(2);
                double avgDur = resultSet.getDouble(3);
                double sumDur = resultSet.getDouble(4);
                int countCompositions = resultSet.getInt(5);
                System.out.printf("%-10.2f%-10.2f%-10.2f%-10.2f%-10d%n", minDur, maxDur, avgDur, sumDur, countCompositions);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void doQuery5(String query) {
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            String columnName = metaData.getColumnName(1);
            System.out.println(columnName);
            System.out.println("----------");
            while (resultSet.next()) {
                String nameAlbum = resultSet.getString(1);
                System.out.println(nameAlbum);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void doQuery6(String query) {
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            String columnName1 = metaData.getColumnName(1);
            String columnName2 = metaData.getColumnName(2);
            System.out.printf("%-10s%-10s%n", columnName1, columnName2);
            System.out.println("--------------");
            while (resultSet.next()) {
                String nameAlbum = resultSet.getString(1);
                String nameComposition = resultSet.getString(2);
                System.out.printf("%-10s%-10s%n", nameAlbum, nameComposition);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void doQuery7(String query) {
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            String columnName1 = metaData.getColumnName(1);
            String columnName2 = metaData.getColumnName(2);
            System.out.printf("%-10s%s%n", columnName1, columnName2);
            System.out.println("------------------");
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                double higherAvg = resultSet.getDouble(2);
                System.out.printf("%-10s%.2f%n", name, higherAvg);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void doQuery8(String query) {
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            String columnName1 = metaData.getColumnName(1);
            String columnName2 = metaData.getColumnName(2);
            System.out.printf("%-10s%s%n", columnName1, columnName2);
            System.out.println("------------------");
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                double duration = resultSet.getDouble(2);
                System.out.printf("%-10s%.2f%n", name, duration);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void doQuery9(String query) {
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            String columnName1 = metaData.getColumnName(1);
            String columnName2 = metaData.getColumnName(2);
            System.out.printf("%-10s%s%n", columnName1, columnName2);
            System.out.println("------------------");
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                double duration = resultSet.getDouble(2);
                System.out.printf("%-10s%.2f%n", name, duration);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void doQuery10(String query) {
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            String columnName1 = metaData.getColumnName(1);
            System.out.println(columnName1);
            System.out.println("----");
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                System.out.println(name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
