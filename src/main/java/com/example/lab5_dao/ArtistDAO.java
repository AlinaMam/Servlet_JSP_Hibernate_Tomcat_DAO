package com.example.lab5_dao;

import com.example.lab4.Album;
import com.example.lab4.Artist;

import java.util.List;

public interface ArtistDAO {
    void addArtist(Artist artist);//create

    List<Artist> getAllArtists();//read

    Artist getArtistById(int id);

    void updateArtist(Artist artist);//update

    void removeArtist(Artist artist);//delete

    List<Album> getAllAlbumsOfArtist(int id);
}

