package com.example.loginlivesession2.account.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Likes {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column
//    private Long boardId;
//
//    @Column
//    private Long userId;


    @JoinColumn(name = "board_id", nullable = false)
    @ManyToOne
    private Board board;

    @JoinColumn(name = "account_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

//    public Likes (Long boardId, Long userId){
//        this.boardId = boardId;
//        this.userId = userId;
//    }

    public Likes (Board board, Account account){
        this.board = board;
        this.account = account;
    }


}
