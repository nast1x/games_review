package com.example.games_back.controller;

import com.example.games_back.model.Games;
import com.example.games_back.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/games")
public class GamesController {

    private final GamesService gamesService;

    @Autowired
    public GamesController(GamesService gamesService) {
        this.gamesService = gamesService;
    }

    @GetMapping
    public ResponseEntity<List<Games>> getAllGames() {
        List<Games> games = gamesService.getAllGames();
        return ResponseEntity.ok(games);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Games> getGameById(@PathVariable Long id) {
        Optional<Games> game = gamesService.getGameById(id);
        return game.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Games> getGameByName(@PathVariable String name) {
        Optional<Games> game = gamesService.getGameByName(name);
        return game.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Games> createGame(@RequestBody Games game) {
        Games savedGame = gamesService.saveGame(game);
        return ResponseEntity.ok(savedGame);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        gamesService.deleteGame(id);
        return ResponseEntity.noContent().build();
    }
}