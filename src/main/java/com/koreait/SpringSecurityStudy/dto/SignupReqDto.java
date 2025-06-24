package com.koreait.SpringSecurityStudy.dto;

import com.koreait.SpringSecurityStudy.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@AllArgsConstructor
public class SignupReqDto {
    private String username;
    private String password;
    private String email;

    public UserEntity toEntity(BCryptPasswordEncoder cryptPasswordEncoder) {
        return UserEntity.builder()
                .username(this.username)
                .password(BCryptPasswordEncoder.encode(this.password))
                .email(this.email)
                .build();

    }
}
