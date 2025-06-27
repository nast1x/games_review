package com.example.games_back.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Review")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idreview;

    @ManyToOne
    @JoinColumn(name = "iduser", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "idgames", nullable = false)
    private Games games;

    @Column(nullable = false, length = 100)
    private String heading;

    @Column(name = "evaluation", nullable = false)
    private Double rating;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String feedback;

    @Column(name = "game_time", nullable = false)
    private Integer timeInGame;

}
