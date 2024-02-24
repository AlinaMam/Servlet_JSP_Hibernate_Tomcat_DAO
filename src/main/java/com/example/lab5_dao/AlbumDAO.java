package com.example.lab5_dao;

import com.example.lab4.Album;
import com.example.lab4.Composition;

import java.util.List;

public interface AlbumDAO {
    void addAlbum(Album album);//create

    List<Album> getAllAlbums();//read

    Album getAlbumById(int id);

    Album getAlbumByName(String name);

    List<Album> getAllAlbumsOfGenre(String genre);

    List<Composition> getAllCompositionsOfAlbum(int id);

    void updateAlbum(Album album);//update

    void removeAlbum(Album album);//delete

}
