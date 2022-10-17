package com.example.loginlivesession2.account.repository;

import com.example.loginlivesession2.account.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {

    Optional<Likes> findByBoardIdAndAccountUsername(Long boardId, String username);

}
