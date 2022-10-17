package com.example.loginlivesession2.account.repository;

import com.example.loginlivesession2.account.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
