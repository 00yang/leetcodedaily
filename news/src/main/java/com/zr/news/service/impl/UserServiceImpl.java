package com.zr.news.service.impl;

import com.zr.news.dao.UserRepository;
import com.zr.news.po.User;
import com.zr.news.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUsers(String username,String password){
        return userRepository.findByUsernameAndPassword(username,password);
    }
}
