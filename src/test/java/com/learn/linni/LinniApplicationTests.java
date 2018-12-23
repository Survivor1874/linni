package com.learn.linni;

import com.alibaba.fastjson.JSON;
import com.learn.linni.common.entity.user.User;
import com.learn.linni.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LinniApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {

		System.out.println(JSON.toJSONString(userMapper.selectById(10)));
	}

	@Test
	public void insertListTest() {
		List<User> list = new ArrayList<>(3);
		User user1 = new User();
		user1.setUsername("yihao");
		user1.setAddress("9090");
		User user2 = new User();
		user2.setUsername("erhao");
		user2.setAddress("9090");
		User user3 = new User();
		user3.setUsername("sanhao");
		user3.setAddress("9090");
		list.add(user1);
		list.add(user2);
		list.add(user3);
		Integer count = userMapper.insterList(list);

		System.out.println("返回成功的数量:" + count);
	}

	@Test
	public  void  updateByUserTest(){
		User user = new User();
		user.setId(37);
		user.setUsername("linjun4");
		user.setBirthday(new Date());
		Integer count = userMapper.updateByUser(user);
		System.out.println("成功修改的数量:" + count);
	}


	@Test
	public void insertUser(){
		User user = new User();
		user.setUsername("linjun9");
		user.setBirthday(new Date());
		Integer count = userMapper.insertUser(user);
		System.out.println("插入了一条数据:"+count);
	}


}

