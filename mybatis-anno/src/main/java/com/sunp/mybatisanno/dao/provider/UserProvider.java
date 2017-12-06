package com.sunp.mybatisanno.dao.provider;

import com.sunp.mybatisanno.bean.UserInfo;
import org.apache.ibatis.jdbc.SQL;

public class UserProvider {

    public String getUserByPhone(UserInfo userInfo){
        SQL sql = new SQL();
        sql.SELECT("*");
        sql.FROM("user");
        if (userInfo.getPhone()!=null){
            sql.WHERE("phone = #{phone,javaType=String,jdbcType=VARCHAR}");
        }
        if (userInfo.getName()!=null){
            sql.WHERE("name = #{name,javaType=String,jdbcType=VARCHAR}");
        }
        System.out.println(sql.toString());
        return sql.toString();
    }


    public String insertUser(UserInfo userInfo){
        SQL sql = new SQL();
        sql.INSERT_INTO("user");

        if (userInfo.getName()!=null){
            sql.VALUES("name","#{name}");
        }
        if (userInfo.getPwd()!=null){
            sql.VALUES("pwd","#{pwd}");
        }
        if (userInfo.getPhone()!=null){
            sql.VALUES("phone","#{phone}");
        }
        if (userInfo.getUpdateDate()!=null){
            sql.VALUES("update_date","#{updateDate}");
        }

        System.out.println(sql.toString());
        return sql.toString();
    }


}
