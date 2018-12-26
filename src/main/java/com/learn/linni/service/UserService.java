package com.learn.linni.service;

import com.alibaba.fastjson.JSON;
import com.learn.linni.common.entity.user.User;
import com.learn.linni.dao.UserMapper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ValueOperations<String, Object> opsForValue;

    @Autowired
    private ListOperations<String, Object> listOperations;

    public User selectById(Integer id){
        String key="user:id:"+id;
        String usertr = (String) opsForValue.get(key);
        User user =null;
        if(StringUtils.isNotBlank(usertr)){
            user= JSON.parseObject(usertr, User.class);
        }

        if(null==user){
            //如果缓存里没查到,则从数据库里查,然后存入缓存
            user = userMapper.selectById(id);
            user = userMapper.selectById(id);
            if(null != user){
                usertr= JSON.toJSONString(user);
                opsForValue.set(key, usertr);
            }
        }

        System.out.println(usertr);

        return  user;
    }
}
