package com.sunp.mybaits;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sunp.mybaits.bean.UserInfo;
import com.sunp.mybaits.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SuppressWarnings("SpringJavaAutowiringInspection")
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybaitsApplicationTests {

	@Autowired
	private UserDao userDao;

	@Test
	public void findById(){
		UserInfo userById = userDao.getUserById(1);
		System.out.println(userById.getName());

	}


}
