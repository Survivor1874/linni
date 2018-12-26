package com.learn.linni.common.manager.impl;


import com.alibaba.fastjson.JSON;
import com.learn.linni.common.entity.user.User;
import com.learn.linni.common.manager.TokenManager;
import com.learn.linni.common.model.TokenModel;
import com.learn.linni.config.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 通过Redis存储和验证token的实现类
 * @see
 * @author ScienJus
 * @date 2015/7/31.
 */
@Component
public class RedisTokenManager implements TokenManager {


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;



  /*  @Autowired
    public void setRedis( RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        //泛型设置成Long后必须更改对应的序列化方案
        redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
    }*/

    public TokenModel createToken(int userId) {
        //使用uuid作为源token
        String token = UUID.randomUUID().toString().replace("-", "");
        TokenModel model = new TokenModel(userId, token);
        String userIdSt=String.valueOf(userId);
        userIdSt="redis:userId:"+userIdSt;
        //存储到redis并设置过期时间
        redisTemplate.boundValueOps(userIdSt).set(token, Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return model;
    }

    public TokenModel getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String[] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        //使用userId和源token简单拼接成的token，可以增加加密措施
      //  int userId = Integer.parseInteger(param[0]);
        int userId=Integer.valueOf(param[0]).intValue();
        String token = param[1];
        return new TokenModel(userId, token);
    }

    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        long userId = model.getUserId();
        String userIdSt=String.valueOf(userId);
        Object tokenOb = redisTemplate.boundValueOps(userIdSt).get();
        String token=String.valueOf(tokenOb);
        if (token == null || !token.equals(model.getToken())) {
            return false;
        }
        //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
        redisTemplate.boundValueOps(userIdSt).expire(Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return true;
    }

    public void deleteToken(long userId) {
        redisTemplate.delete(String.valueOf(userId));
    }


    /**
     * 新增缓存里的user
     * @param id
     * @param user
     */
    @Override
    public void setResid(Long id, User user) {
        String userSt = JSON.toJSONString(user);
        String key="user:id:"+id;
       ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        opsForValue.set(key,userSt);
        System.out.println("插入缓存成功"+key);
    }
    /**
     * 根据id查询缓存里的user
     * @param id
     */
    @Override
    public User getRedis(Long id){
        String key="user:id:"+id;
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        String users = (String)opsForValue.get(key);
        //    User user = com.alibaba.fastjson.JSON.parseObject(users, User.class);
        User user = JSON.parseObject(users, User.class);
        if(!StringUtils.isEmpty(users)){
            System.out.println("从缓存里查出了user"+key);
        }

        return user;
    }
}
