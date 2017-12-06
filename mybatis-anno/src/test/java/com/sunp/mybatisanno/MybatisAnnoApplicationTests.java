package com.sunp.mybatisanno;

import com.sunp.mybatisanno.bean.UserInfo;
import com.sunp.mybatisanno.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisAnnoApplicationTests {

	@Autowired
	private UserDao userDao;

	@Test
	public void findById(){
		UserInfo userById = userDao.getUserById(1);
		System.out.println(userById.getName());
	}

	@Test
	public void findByPhoneTest(){
		UserInfo info=new UserInfo();
		info.setName("sunpeng");
//		info.setPhone("15559199053");
		List<UserInfo> users = userDao.getUserByPhone(info);
		System.out.println(users);
	}

	@Test
	public void insertUserTest(){
		UserInfo info=new UserInfo();
		info.setName("su");
		info.setPhone("153");
		info.setPwd("1246");
		info.setUpdateDate(new Date(System.currentTimeMillis()+100000));
		userDao.insert(info);
	}

}
