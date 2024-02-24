package com.example.lab5_util;

import com.example.lab4.Album;
import com.example.lab4.Artist;
import com.example.lab4.Composition;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {
    private static SessionFactory factory;

    public static SessionFactory getSessionFactory() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Album.class)
                .addAnnotatedClass(Artist.class)
                .addAnnotatedClass(Composition.class)
                .buildSessionFactory();
        return factory;
    }
}
