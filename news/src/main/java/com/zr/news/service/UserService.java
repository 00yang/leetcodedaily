package com.zr.news.service;

import com.zr.news.po.User;

public interface UserService {

    User checkUsers(String username,String password);

}
