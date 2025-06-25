package com.koreait.SpringSecurityStudy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class User {
    private Integer userId;
    private String username;
    private String password;
    private String email;
}

// 권한 목록과 우저 권한 목록을 따로 둔 이유
// 만약 유저당 하나의 권한만 가질수있을때

// 하지만 이러면 관리자 이면서 일반사용자의 동시 권한은 가질수 없다
// 유저는 여러 롤을 받을수 있고
// 롤도 여러 유저에게 부여할수있음

// 이러면 권한 관리가 복잡해지기때문에 권한 목록인 중간 테이블을 따로 분리해서 관리
