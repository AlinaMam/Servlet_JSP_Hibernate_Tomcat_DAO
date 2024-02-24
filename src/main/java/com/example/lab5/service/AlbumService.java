package com.example.lab5.service;

import com.example.lab4.Album;
import com.example.lab4.Composition;
import com.example.lab5_dao.AlbumDAO;
import com.example.lab5_util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AlbumService implements AlbumDAO {
    @Override
    public void addAlbum(Album album) {
        try (SessionFactory factory = Util.getSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.persist(album);
            session.getTransaction().commit();
        }
    }

    @Override
    public Album getAlbumById(int id) {
        Album album = null;
        try (SessionFactory factory = Util.getSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            album = session.createQuery("from Album where id = :id", Album.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.getTransaction().commit();
        }
        return album;
    }

    @Override
    public List<Album> getAllAlbums() {
        List<Album> albums = null;
        try (SessionFactory factory = Util.getSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            albums = session.createQuery("from Album", Album.class).getResultList();
            session.getTransaction().commit();
        }
        return albums;
    }

    @Override
    public Album getAlbumByName(String name) {
        Album album = null;
        try (SessionFactory factory = Util.getSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            album = session.createQuery("from Album where lower(trim(name)) like lower(trim(:name))", Album.class)
                    .setParameter("name", name)
                    .getSingleResult();
            session.getTransaction().commit();
        }
        return album;
    }

    @Override
    public List<Album> getAllAlbumsOfGenre(String genre) {
        List<Album> albums = null;
        try (SessionFactory factory = Util.getSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            albums = session.createQuery("from Album where lower(trim(genre)) like lower(trim(:genre))", Album.class)
                    .setParameter("genre", genre)
                    .getResultList();
            session.getTransaction().commit();
        }
        return albums;
    }

    @Override
    public List<Composition> getAllCompositionsOfAlbum(int id) {
        List<Composition> compositions = null;
        try (SessionFactory factory = Util.getSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Album album = session.get(Album.class, id);
            compositions = album.getCompositions();
            session.getTransaction().commit();
        }
        return compositions;
    }

    @Override
    public void updateAlbum(Album album) {
        try (SessionFactory factory = Util.getSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.merge(album);
            session.getTransaction().commit();
        }
    }

    @Override
    public void removeAlbum(Album album) {
        try (SessionFactory factory = Util.getSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.remove(album);
            session.getTransaction().commit();
        }
    }
}

