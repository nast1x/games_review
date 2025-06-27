package com.example.games_back.repository;

import com.example.games_back.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByUser_Id(Long iduser);
    List<Review> findByGames_Id(Long idgames);
}