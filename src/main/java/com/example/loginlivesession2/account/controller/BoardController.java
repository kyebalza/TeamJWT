package com.example.loginlivesession2.account.controller;

import com.example.loginlivesession2.account.dto.request.BoardRequestDto;
import com.example.loginlivesession2.account.dto.response.CommonResponseDto;
import com.example.loginlivesession2.account.dto.response.ResponseDto;
import com.example.loginlivesession2.account.service.BoardService;
import com.example.loginlivesession2.security.user.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/post")
    public CommonResponseDto create(@Valid @RequestBody BoardRequestDto boardRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl){
        return boardService.create(boardRequestDto, userDetailsImpl.getAccount().getUsername());
    }
//    @PostMapping("/post")
//    public ResponseDto create(@Valid @RequestBody BoardRequestDto boardRequestDto, HttpServletRequest request){
//        return boardService.create(boardRequestDto, request);
//    }
}
