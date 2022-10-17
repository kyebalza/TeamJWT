package com.example.loginlivesession2.account.service;

import com.example.loginlivesession2.account.dto.request.BoardRequestDto;
import com.example.loginlivesession2.account.dto.response.CommonResponseDto;
import com.example.loginlivesession2.account.dto.response.ResponseDto;
import com.example.loginlivesession2.account.entity.Account;
import com.example.loginlivesession2.account.entity.Board;
import com.example.loginlivesession2.account.repository.AccountRepository;
import com.example.loginlivesession2.account.repository.BoardRepository;
import com.example.loginlivesession2.jwt.util.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final AccountRepository accountRepository;

    //JWT
    private final JwtUtil jwtUtil;
    //게시글 작성

    private Account getAcount(String username){
        Account account = accountRepository.findByUsername(username)
                .orElseThrow( ()-> new UsernameNotFoundException("유저를 찾을 수 없습니다."));
        return account;
    }

    public CommonResponseDto create(BoardRequestDto boardRequestDto, String username) {
        Account account = getAcount(username);
        Board board = new Board(boardRequestDto, account);

        boardRepository.save(board);

        return new CommonResponseDto(true, board);

    }

//    @Transactional
//    public Account validateMember(HttpServletRequest request) {
//        if (!jwtUtil.tokenValidation(request.getHeader("Refresh-Token"))) {
//            return null;
//        }
//        return jwtUtil.getMemberFromAuthentication();
//    }
//    public ResponseDto create(BoardRequestDto boardRequestDto, HttpServletRequest request) {
//        if (null == request.getHeader("Refresh-Token")) {
//            return ResponseDto.fail("MEMBER_NOT_FOUND",
//                    "로그인이 필요합니다.");
//        }
//
//        if (null == request.getHeader("Authorization")) {
//            return ResponseDto.fail("MEMBER_NOT_FOUND",
//                    "로그인이 필요합니다.");
//        }
//
//        Account account = validateMember(request);
//        if (null == account) {
//            return ResponseDto.fail("INVALID_TOKEN", "Token이 유효하지 않습니다.");
//        }
//
//        Board post = Board.builder()
//                .boardTitle(requestDto.getTitle())
//                .content(requestDto.getContent())
//                .member(member)
//                .build();
//        postRepository.save(post);
//        return ResponseDto.success(
//                PostResponseDto.builder()
//                        .id(post.getId())
//                        .title(post.getTitle())
//                        .content(post.getContent())
//                        .author(post.getMember().getNickname())
//                        .createdAt(post.getCreatedAt())
//                        .modifiedAt(post.getModifiedAt())
//                        .build()
//        );
//
//    }
}
