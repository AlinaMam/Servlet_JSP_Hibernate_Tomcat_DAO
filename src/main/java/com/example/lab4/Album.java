package com.example.lab4;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"artist", "compositions"})
@Builder
@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "genre", length = 50, nullable = false)
    private String genre;
    @ManyToOne
    @JoinColumn(name = "id_artist", nullable = false)
    private Artist artist;
    @OneToMany(mappedBy = "album", fetch = FetchType.EAGER)
    private List<Composition> compositions;

    public void addCompositionToAlbum(Composition composition) {
        if (compositions == null) {
            compositions = new ArrayList<>();
        }
        compositions.add(composition);
        composition.setAlbum(this);
    }
}

