package com.koreait.SpringSecurityStudy.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.security.SecureRandom;

@Data
@AllArgsConstructor
@Builder
public class UserEntity {
    private Integer userId;
    private String username;
    private String password;
    private String email;

}
