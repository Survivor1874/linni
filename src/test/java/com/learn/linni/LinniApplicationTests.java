package com.learn.linni;

import com.alibaba.fastjson.JSON;
import com.learn.linni.common.entity.user.User;
import com.learn.linni.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LinniApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RedisTemplate<String, Long>  longRedisTemplate;

	@Test
	public void contextLoads() {

		System.out.println(JSON.toJSONString(userMapper.selectById(10)));
	}

	@Test
	public void insertListTest() {
		List<User> list = new ArrayList<>(3);
		User user1 = new User();
		user1.setUsername("一号");
		user1.setAddress("9090");
		user1.setBirthday(new Date());
		User user2 = new User();
		user2.setUsername("二号");
		user2.setAddress("9090");
		user2.setBirthday(new Date());
		User user3 = new User();
		user3.setUsername("三号");
		user3.setAddress("9090");
		user3.setBirthday(new Date());
		list.add(user1);
		list.add(user2);
		list.add(user3);
		//Integer count = userMapper.insterList(list);
		Integer count = userMapper.testInsertList(list);

		System.out.println("返回成功的数量:" + count);
	}

	@Test
	public  void  updateByUserTest(){
		User user = new User();
		user.setId(37);
		user.setUsername("linjun4");
		user.setAddress("1245");
	//	Integer count = userMapper.updateByUser(user);
		Integer count = userMapper.testUpdateByUser(user);
		System.out.println("成功修改的数量:" + count);
	}


	@Test
	public void insertUser(){
		User user = new User();
		user.setUsername("linjun9");
		user.setBirthday(new Date());
		user.setAddress("1");
		Integer count = userMapper.testInsertUser(user);
		System.out.println("插入了一条数据:"+count);
	}

	@Test
	public void testByUser(){
		User user=new User();
		user.setSex("2");
		List<User> users = userMapper.testByUser(user);
		String userst = JSON.toJSONString(users);
		System.out.println(userst);
	}

	@Test
	public void selectByIdTest(){
		int   id=37;
		User user = userMapper.selectById(id);
		String usert = JSON.toJSONString(user);
		System.out.println(usert);
	}

	@Test
	public  void longTest(){
		ValueOperations<String, Long> opsForValue = longRedisTemplate.opsForValue();
		opsForValue.set("key1",78L,15000, TimeUnit.MINUTES);

	}



}

