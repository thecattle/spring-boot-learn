package com.sunp.mybatisanno.dao;

import com.sunp.mybatisanno.bean.UserInfo;
import com.sunp.mybatisanno.dao.provider.UserProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface UserDao {

    @Results({
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "updateDate", column = "update_date"),
    })
    @Select("select * from user where id = #{id}")
    UserInfo getUserById(@Param(value = "id") int id);


    @SelectProvider(type = UserProvider.class,method = "getUserByPhone")
    List<UserInfo> getUserByPhone(UserInfo userInfo);


    @Transactional
    @SelectProvider(type = UserProvider.class,method = "insertUser")
    void insert(UserInfo userInfo);
}
