package com.example.games_back.repository;

import com.example.games_back.model.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GamesRepository extends JpaRepository<Games, Long> {
    Optional<Games> findByName(String name);
}