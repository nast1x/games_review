package com.example.games_back.service;
import com.example.games_back.model.Games;
import com.example.games_back.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GamesService {
    private final GamesRepository gamesRepository;

    @Autowired
    public GamesService(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    public List<Games> getAllGames() {
        return gamesRepository.findAll();
    }

    public Optional<Games> getGameById(Long id) {
        return gamesRepository.findById(id);
    }

    public Optional<Games> getGameByName(String name) {
        return gamesRepository.findByName(name);
    }

    public Games saveGame(Games game) {
        return gamesRepository.save(game);
    }

    public void deleteGame(Long id) {
        gamesRepository.deleteById(id);
    }

}
