package com.example.loginlivesession2.account.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@Getter
//@RequiredArgsConstructor
public class CommonResponseDto {
    private Boolean success;
    private Object data;

    public CommonResponseDto (Boolean success, Object data){
        this.success = success;
        this.data = data;
    }
}
