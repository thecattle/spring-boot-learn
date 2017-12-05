package com.sunp.mybaits.dao;

import com.sunp.mybaits.bean.UserInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {

    @Results({
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "updateDate", column = "update_date"),
    })
    @Select("select * from user where id = #{id}")
    UserInfo getUserById(@Param(value = "id") int id);
}
