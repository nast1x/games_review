package com.example.games_back.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Games")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Games {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "idgames")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String developer;

    @Column(nullable = false)
    private String genre;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "year_release", nullable = false)
    private Integer yearRelease;

    @OneToMany(mappedBy = "idreview", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Review> reviews;
}
