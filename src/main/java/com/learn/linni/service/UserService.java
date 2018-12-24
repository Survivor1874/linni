package com.learn.linni.service;

import com.alibaba.fastjson.JSON;
import com.learn.linni.common.entity.user.User;
import com.learn.linni.dao.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisService redisService;

    @Autowired
    ///@Resource
    private RedisTemplate<String, String> template;

    public String selectById(Integer id){
      //  ValueOperations<String, String> forValue = template.opsForValue();
        String key="user:id:"+id;
      //  String valueUser = forValue.get(key);
        User valueUser = (User)redisService.get(key);
        String usertr = JSON.toJSONString(valueUser);

        if(StringUtils.isBlank(usertr)){
            //如果缓存里没查到,则从数据库里查,然后存入缓存
            valueUser = userMapper.selectById(id);
            usertr= JSON.toJSONString(valueUser);
            boolean set = redisService.set(key, valueUser);
        }

        System.out.println(usertr);
        return  usertr;
    }
}
