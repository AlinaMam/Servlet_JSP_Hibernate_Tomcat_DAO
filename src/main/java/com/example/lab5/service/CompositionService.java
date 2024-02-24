package com.example.lab5.service;

import com.example.lab4.Composition;
import com.example.lab5_dao.CompositionDAO;
import com.example.lab5_util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CompositionService implements CompositionDAO {
    @Override
    public void addComposition(Composition composition) {
        try (SessionFactory factory = Util.getSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.persist(composition);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Composition> getAllCompositions() {
        List<Composition> compositions = null;
        try (SessionFactory factory = Util.getSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            compositions = session.createQuery("from Composition ", Composition.class)
                    .getResultList();
            session.getTransaction().commit();
        }
        return compositions;
    }

    @Override
    public Composition getCompositionById(int id) {
        Composition composition = null;
        try (SessionFactory factory = Util.getSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            composition = session.createQuery("from Composition where id = :id", Composition.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.getTransaction().commit();
        }
        return composition;
    }

    @Override
    public Composition getCompositionByName(String name) {
        Composition composition = null;
        try (SessionFactory factory = Util.getSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            composition = session.createQuery("from Composition where lower(trim(name)) like lower(trim(:name))", Composition.class)
                    .setParameter("name", name)
                    .getSingleResult();
            session.getTransaction().commit();
        }
        return composition;
    }

    @Override
    public void updateComposition(Composition composition) {
        try (SessionFactory factory = Util.getSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.merge(composition);
            session.getTransaction().commit();
        }
    }

    @Override
    public void removeComposition(Composition composition) {
        try (SessionFactory factory = Util.getSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.remove(composition);
            session.getTransaction().commit();
        }
    }
}

