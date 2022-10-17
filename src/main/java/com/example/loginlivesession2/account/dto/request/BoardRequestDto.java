package com.example.loginlivesession2.account.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardRequestDto {

    @NotBlank(message = "제목")
    private String boardTitle;

    @NotBlank(message = "내용")
    private String boardContent;
}
