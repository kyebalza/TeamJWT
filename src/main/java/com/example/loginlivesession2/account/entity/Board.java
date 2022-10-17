package com.example.loginlivesession2.account.entity;

import com.example.loginlivesession2.account.dto.request.BoardRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board extends Timestamped{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "account_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @Column(nullable = false)
    private String boardTitle;

    @Column(nullable = false)
    private String boardContent;

    public Board(Long id){
        this.id = id;
    }

    public Board(BoardRequestDto boardRequestDto, Account account){
        this.boardTitle = boardRequestDto.getBoardTitle();
        this.boardContent = boardRequestDto.getBoardContent();
        this.account = account;
    }

}
