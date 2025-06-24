package com.koreait.SpringSecurityStudy.repositary;

import com.koreait.SpringSecurityStudy.mapper.UserMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private UserMapper userMapper;

    public int addUser(User user){
        return userMapper.addUser(user);
    }
}
