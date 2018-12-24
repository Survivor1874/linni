package com.learn.linni.controllor;



import com.alibaba.fastjson.JSON;
import com.learn.linni.common.entity.user.User;
import com.learn.linni.dao.UserMapper;
import com.learn.linni.service.RedisService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisService redisService;


    @GetMapping("/test")
    public String test(){
      //  return "aaa";
       return getHellow();
    }

    public String getHellow(){
        return "2345";
    }


    @GetMapping("/selectById")
    public String  selectById(){
        Integer id = 10;
        String usertr = redisService.selectById(id);
        return usertr;
    }


}
