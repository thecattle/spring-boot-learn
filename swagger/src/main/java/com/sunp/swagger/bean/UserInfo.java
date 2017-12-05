package com.sunp.swagger.bean;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UserInfo implements Serializable{

    private static final long serialVersionUID = 114185846403745328L;

    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("密码")
    private String pwd;
    @ApiModelProperty("年龄")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
