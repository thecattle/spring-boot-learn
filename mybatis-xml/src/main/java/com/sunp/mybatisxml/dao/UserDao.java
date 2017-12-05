package com.sunp.mybatisxml.dao;

import com.sunp.mybatisxml.bean.UserInfo;

import java.util.List;

public interface UserDao {

    List<UserInfo> getAll();

    UserInfo getOne(Integer id);

    void insert(UserInfo user);

    void update(UserInfo user);

    void delete(Integer id);
}
