package com.koreait.SpringSecurityStudy.mapper;


import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int addUser(User user);
}
