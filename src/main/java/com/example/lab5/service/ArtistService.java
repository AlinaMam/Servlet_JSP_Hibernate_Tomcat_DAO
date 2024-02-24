package com.example.lab5.service;

import com.example.lab4.Album;
import com.example.lab4.Artist;
import com.example.lab5_dao.ArtistDAO;
import com.example.lab5_util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ArtistService implements ArtistDAO {
    @Override
    public void addArtist(Artist artist) {
        try (SessionFactory factory = Util.getSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.persist(artist);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Artist> getAllArtists() {
        List<Artist> artists = null;
        try (SessionFactory factory = Util.getSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            artists = session.createQuery("from Artist", Artist.class)
                    .getResultList();
            session.getTransaction().commit();
        }
        return artists;
    }

    @Override
    public Artist getArtistById(int id) {
        Artist artist = null;
        try (SessionFactory factory = Util.getSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            artist = session.createQuery("from Artist where id = :id", Artist.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.getTransaction().commit();
        }
        return artist;
    }

    @Override
    public void updateArtist(Artist artist) {
        try (SessionFactory factory = Util.getSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.merge(artist);
            session.getTransaction().commit();
        }
    }

    @Override
    public void removeArtist(Artist artist) {
        try (SessionFactory factory = Util.getSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.remove(artist);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Album> getAllAlbumsOfArtist(int id) {
        List<Album> albums = null;
        try (SessionFactory factory = Util.getSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Artist artist = session.createQuery("from Artist where id = :id", Artist.class)
                    .setParameter("id", id)
                    .getSingleResult();
            albums = artist.getAlbums();
            session.getTransaction().commit();
        }
        return albums;
    }
}

