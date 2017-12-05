package com.sunp.mybatisxml;

import com.sunp.mybatisxml.bean.UserInfo;
import com.sunp.mybatisxml.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisXmlApplicationTests {

	@Autowired
	private UserDao userDao;

	@Test
	public void contextLoads() {
		List<UserInfo> all = userDao.getAll();
		System.out.println(all);
	}

}
