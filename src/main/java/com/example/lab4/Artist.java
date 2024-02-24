package com.example.lab4;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "albums")
@Builder
@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "surname", length = 50)
    private String surname;
    @OneToMany(mappedBy = "artist", fetch = FetchType.EAGER)
    private List<Composition> compositions;
    @OneToMany(mappedBy = "artist", fetch = FetchType.EAGER)
    private List<Album> albums;

    public void addAlbumToArtist(Album album) {
        if (albums == null) {
            albums = new ArrayList<>();
        }
        albums.add(album);
        album.setArtist(this);
    }

    public void addCompositionToArtist(Composition composition) {
        if (compositions == null) {
            compositions = new ArrayList<>();
        }
        compositions.add(composition);
        composition.setArtist(this);
    }
}
