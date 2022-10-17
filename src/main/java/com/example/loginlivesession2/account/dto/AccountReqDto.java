package com.example.loginlivesession2.account.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class AccountReqDto {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String phoneNumber;

    public AccountReqDto(String username, String password, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public void setEncodePwd(String encodePwd) {
        this.password = encodePwd;
    }

}
