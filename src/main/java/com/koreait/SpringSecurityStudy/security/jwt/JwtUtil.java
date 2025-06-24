package com.koreait.SpringSecurityStudy.security.jwt;


import lombok.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.KeyStore;

@Component
public class JwtUtil {
    // 현재 시각 기준으로 30일 뒤까지 보관한다.

    public String removeBearer(String bearerToken) {
        return bearerToken.replaceFirst("Bearer ","");
    }

    public

}
