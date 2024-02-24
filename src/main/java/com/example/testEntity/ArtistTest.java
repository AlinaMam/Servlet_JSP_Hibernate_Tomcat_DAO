package com.example.testEntity;

import com.example.lab4.Artist;
import com.example.lab5.service.ArtistService;

public class ArtistTest {
    public static void main(String[] args) {
        ArtistService artistService = new ArtistService();

        //create
        Artist artist1 = Artist.builder()
                .name("Shakira")
                .build();

        Artist artist2 = Artist.builder()
                .name("Maluma")
                .build();

        Artist artist3 = Artist.builder()
                .name("Jenifer")
                .surname("Lopez")
                .build();

        artistService.addArtist(artist1);
        artistService.addArtist(artist2);
        artistService.addArtist(artist3);

        //read
        Artist art2 = artistService.getArtistById(2);

        //update
        Artist art3 = artistService.getArtistById(4);
        art3.setName("Bad Bunny");
        artistService.updateArtist(art3);

        //delete
        artistService.removeArtist(art2);
    }
}
