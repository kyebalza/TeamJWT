package com.example.loginlivesession2.account.controller;

import com.example.loginlivesession2.account.dto.response.CommonResponseDto;
import com.example.loginlivesession2.account.service.LikesService;
import com.example.loginlivesession2.security.user.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
@RestController
public class LikesController {
    private final LikesService likesService;

    @PostMapping("/post/{id}/like")
    public CommonResponseDto likeUp(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl){
        likesService.likeUp(id, userDetailsImpl.getAccount().getUsername());
        return new CommonResponseDto(true,null);
    }
}
