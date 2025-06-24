package com.koreait.SpringSecurityStudy.service;


import com.koreait.SpringSecurityStudy.dto.ApiRespDto;
import com.koreait.SpringSecurityStudy.dto.SignupReqDto;
import com.koreait.SpringSecurityStudy.repositary.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public ApiRespDto<?> addUser(SignupReqDto signupReqDto){
        int result = userRepository.addUser(signupReqDto.toEntity(BCryptPasswordEncoder()));
        return new ApiRespDto<>("success","회원가입 성공", result);
    }
}
