package com.example.testEntity;

import com.example.lab4.Album;
import com.example.lab4.Artist;
import com.example.lab5.service.AlbumService;
import com.example.lab5.service.ArtistService;

public class AlbumTest {
    public static void main(String[] args) {
        ArtistService artistService = new ArtistService();
        AlbumService albumService = new AlbumService();

        //create
        Artist artist1 = Artist.builder()
                .name("Enrique")
                .surname("Iglesias")
                .build();

        Artist artist2 = Artist.builder()
                .name("Ariana")
                .surname("Grande")
                .build();

        Artist artist3 = Artist.builder()
                .name("Aleksandr")
                .surname("Serov")
                .build();

        Album album1 = Album.builder()
                .name("Amor")
                .genre("pop")
                .build();

        Album album2 = Album.builder()
                .name("Las nubes")
                .genre("pop")
                .build();

        Album album3 = Album.builder()
                .name("Mi país")
                .genre("pop")
                .build();

        Album album4 = Album.builder()
                .name("Amigos")
                .genre("romantic")
                .build();

        Album album5 = Album.builder()
                .name("No")
                .genre("pop")
                .build();

        //create
        /*artist3.addAlbumToArtist(album4);
        artistService.addArtist(artist3);
        albumService.addAlbum(album4);*/

        /*Artist artist4 = artistService.getArtistById(5);
        album5.setArtist(artist4);
        albumService.addAlbum(album5);*/


        //read
        //by id
       /* Album albu5 = albumService.getAlbumById(9);
        System.out.println(album5);*/

        //all albums
        /*List<Album> listAlbums = albumService.getAllAlbums();
        listAlbums.forEach(System.out::println);*/

        //by name
       /* Album album6 = albumService.getAlbumByName("Las nubes");
        System.out.println(album6);*/

        //all of genre
        /*List<Album> pop = albumService.getAllAlbumsOfGenre("pop");
        pop.forEach(System.out::println);*/

        //update
        /*Album album7 = albumService.getAlbumByName("Las nubes");
        album7.setGenre("R&B");
        albumService.updateAlbum(album7);*/

        //delete
        /*Album album8 = albumService.getAlbumById(11);
        albumService.removeAlbum(album8);*/


    }
}
