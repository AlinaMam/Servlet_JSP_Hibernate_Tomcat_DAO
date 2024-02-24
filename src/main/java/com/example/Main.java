package com.example;

public class Main {
    public static void main(String[] args) {
        //Лабораторные работы №1-2:
        //Задание №1
//        Database.createTable(Database.CREATE_TABLE1);
//        Database.createTable(Database.CREATE_TABLE2);
//        Database.createTable(Database.CREATE_TABLE3);

        //Задание №2
        //Добавление данных в таблицу artists
        /*Database.insertInArtists("Ivan", "Ivanov");
        Database.insertInArtists("Petya", "Petrov");
        Database.insertInArtists("Ilona", "Maskova");
        Database.insertInArtists("Vasya", "Vasilyev");
        Database.insertInArtists("Sergey", "Sergeev");*/

        //Добавление данных в таблицу album
      /*  Database.insertInAlbum(2, "El cielo", "pop");
        Database.insertInAlbum(1, "Los rascacielos", "rock");
        Database.insertInAlbum(3, "El disco", "R&B");
        Database.insertInAlbum(2, "Mi país", "folk");
        Database.insertInAlbum(4, "Amigo", "pop");*/

        //Добавление данных в таблицу composition
       /* Database.insertInComposition(2, "Amor", 3.01);
        Database.insertInComposition(1, "Qué tal", 2.58);
        Database.insertInComposition(3, "Adios", 3.02);
        Database.insertInComposition(1, "Address", 3.23);
        Database.insertInComposition(4, "Capítulo", 2.57);*/

        //Задание №3
        //1
        /*String query1 = "SELECT CONCAT_WS(', ', name::text, duration::text) as \"Song Details\" FROM composition;";
        Database.doQuery1(query1);*/

        //2
        /*String query2 = "SELECT name, duration " +
                "FROM composition " +
                "WHERE duration NOT BETWEEN 2.58 and 3.02 " +
                "ORDER BY duration desc;";
        Database.doQuery2(query2);*/

        //3
        /*String query3 = "SELECT surname as \"Surname\" FROM artist WHERE surname LIKE '_e%' AND id in(1, 2);";
        Database.doQuery3(query3);*/

        //4
        /*String query4 = "SELECT MIN(duration) as minDur, " +
                "MAX(duration) as maxDur," +
                "AVG(duration) as avgDur," +
                "SUM(duration) as sumDur," +
                "COUNT(name) as countCompositions " +
                "FROM composition;";
        Database.doQuery4(query4);*/

        //5
       /* String query5 = "SELECT name as \"Name Album\" " +
                "FROM album " +
                "WHERE id_artist = " +
                "(SELECT id FROM artist WHERE name = 'Vasya');";
        Database.doQuery5(query5);*/

        //6
        /*String query6 = "SELECT album.name, v.name " +
                "FROM album " +
                "JOIN " +
                "(SELECT composition.id_album, composition.name " +
                "FROM composition " +
                "WHERE duration = " +
                "(SELECT dur from (select id_album, min(duration) as dur " +
                "from composition " +
                "group by id_album " +
                "having id_album = 1) as t)) as v on album.id = v.id_album;";
        Database.doQuery6(query6);*/

        //7
        /*String query7 = "select name, duration " +
                "from composition " +
                "where duration > " +
                "(select avg(duration) from composition);";
        Database.doQuery7(query7);*/

        //8
     /*   String query8 = "select name, duration " +
                "from composition " +
                "where duration > " +
                "(select duration from composition where id_album = 1 limit 1);";
        Database.doQuery8(query8);*/

        //9
        /*String query9 = "select name, duration " +
                "from composition " +
                "where duration > " +
                "(select max(duration) from composition where id_album = 2);";
        Database.doQuery9(query9);*/

        //10
        /*String query10 = "select name " +
                "from composition where duration = " +
                "(select duration from composition where name = 'Address') " +
                "and name <> 'Address';";
        Database.doQuery10(query10);*/

        //Лабораторная работа 2
        //Задание 3
        /*String query1 = "SELECT table_name " +
                        "FROM information_schema.tables " +
                        "WHERE table_schema = 'public';";
        Metadata.printNameTables(query1);*/

       /* String query2 = "SELECT column_name " +
                "FROM information_schema.columns " +
                "WHERE table_schema = 'public' AND table_name = 'artist';";
        Metadata.printNameColumns(query2);*/
    }
}
