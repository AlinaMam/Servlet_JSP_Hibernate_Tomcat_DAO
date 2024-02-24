package com.example.lab5_dao;

import com.example.lab4.Composition;

import java.util.List;

public interface CompositionDAO {
    void addComposition(Composition composition);//create

    List<Composition> getAllCompositions();//read

    Composition getCompositionById(int id);

    Composition getCompositionByName(String name);

    void updateComposition(Composition composition);//update

    void removeComposition(Composition composition);//delete
}
