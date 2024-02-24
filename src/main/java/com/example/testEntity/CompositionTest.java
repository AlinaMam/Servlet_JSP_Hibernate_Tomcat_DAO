package com.example.testEntity;

import com.example.lab4.Composition;
import com.example.lab5.service.AlbumService;
import com.example.lab5.service.ArtistService;
import com.example.lab5.service.CompositionService;

public class CompositionTest {
    public static void main(String[] args) {
        ArtistService artistService = new ArtistService();
        CompositionService compositionService = new CompositionService();
        AlbumService albumService = new AlbumService();

        Composition composition1 = Composition.builder()
                .name("Как быть")
                .duration(3.23)
                .build();

        Composition composition2 = Composition.builder()
                .name("Ты меня любишь")
                .duration(2.44)
                .build();

        Composition composition3 = Composition.builder()
                .name("Миг")
                .duration(2.53)
                .build();

        Composition composition4 = Composition.builder()
                .name("O-la-la")
                .duration(2.51)
                .build();

        //create
       /* Artist artist1 = Artist.builder()
                .name("Нюша")
                .build();

        artist1.addCompositionToArtist(composition3);
        artistService.addArtist(artist1);
        compositionService.addComposition(composition3);*/

        /*Album album2 = albumService.getAlbumById(12);
        Artist artist2 = artistService.getArtistById(5);
        artist2.addCompositionToArtist(composition4);
        album2.addCompositionToAlbum(composition4);
        compositionService.addComposition(composition4);*/

        /*Artist artist2 = artistService.getArtistById(14);
        artist2.addCompositionToArtist(composition1);
        artist2.addCompositionToArtist(composition2);
        compositionService.addComposition(composition1);
        compositionService.addComposition(composition2);*/

        //read

        //all compositions
        /*List<Composition> compositions = compositionService.getAllCompositions();
        System.out.println(compositions);*/

        //by id
       /* Composition composition5 = compositionService.getCompositionById(6);
        System.out.println(composition5);*/

        //by name
        /*Composition composition6 = compositionService.getCompositionByName("Миг");
        System.out.println(composition6);*/

        //update
        /*Composition composition7 = compositionService.getCompositionByName("Как быть");
        composition7.setName("Ночь");
        compositionService.updateComposition(composition7);*/

        //remove
        /*Composition composition3 = compositionService.getCompositionById(2);
        Composition composition4 = compositionService.getCompositionById(3);
        Composition composition5 = compositionService.getCompositionById(4);
        compositionService.removeComposition(composition3);
        compositionService.removeComposition(composition4);
        compositionService.removeComposition(composition5);*/
    }
}
