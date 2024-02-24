package com.example.lab4;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"album", "artist"})
@Builder
@Entity
@Table(name = "composition")
public class Composition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "duration", nullable = false)
    private double duration;
    @ManyToOne
    @JoinColumn(name = "id_Album")
    private Album album;
    @ManyToOne
    @JoinColumn(name = "id_artist", nullable = false)
    private Artist artist;
}
