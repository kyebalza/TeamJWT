package com.example.loginlivesession2.account.service;

import com.example.loginlivesession2.account.dto.response.CommonResponseDto;
import com.example.loginlivesession2.account.entity.Account;
import com.example.loginlivesession2.account.entity.Board;
import com.example.loginlivesession2.account.entity.Likes;
import com.example.loginlivesession2.account.repository.AccountRepository;
import com.example.loginlivesession2.account.repository.LikesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LikesService {

    private final LikesRepository likesRepository;
    private final AccountRepository accountRepository;

    private Account getAcount(String username){
        Account account = accountRepository.findByUsername(username)
                .orElseThrow( ()-> new UsernameNotFoundException("유저를 찾을 수 없습니다."));
        return account;
    }
    //public void CommonResponseDto likeUp(Long boardId, Long userId) {
    public void likeUp(Long boardId, String username) {
        //1. boardId 와 userId로 좋아요 여부 판단하기
        //Optional<Likes> likes = likesRepository.findByBoardIdAndUserId(boardId, userId);
        Optional<Likes> likes = likesRepository.findByBoardIdAndAccountUsername(boardId, username);
        //Exists 메소드
        // id 만 가져오기
        Account account = getAcount(username);
        Board board = new Board(boardId);
        if (likes.isPresent()){
        //2-1. 있으면 삭제
            likesRepository.delete(likes.get());
            //id 만 받아와서 삭제!!
            new CommonResponseDto(true,"삭제가 완료되었습니다.");
        }else {
        //2-2. 없으면 등록
            Likes like = new Likes(board, account);
            likesRepository.save(like);
            new CommonResponseDto(true, like);
        }

    }
}
