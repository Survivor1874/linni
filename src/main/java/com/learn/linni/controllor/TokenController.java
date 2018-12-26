package com.learn.linni.controllor;

import com.learn.linni.common.entity.user.User;
import com.learn.linni.common.manager.TokenManager;
import com.learn.linni.common.model.TokenModel;
import com.learn.linni.config.ResultStatus;
import com.learn.linni.dao.UserMapper;
import com.learn.linni.model.ResultModel;

import com.learn.linni.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * 获取和删除token的请求地址，在Restful设计中其实就对应着登录和退出登录的资源映射
 * @author ScienJus
 * @date 2015/7/30.
 */
@RestController
@RequestMapping("/tokens")
public class TokenController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private TokenManager tokenManager;

    @RequestMapping(value="/token/{id}/{password}",method = RequestMethod.GET ,produces =  "application/json")
    public ResponseEntity<ResultModel> LogUser(@PathVariable("id") int id,@PathVariable("password") int password){
        //  Integer  id = 29;
        User user = userMapper.selectById(id);
        if(user==null||!user.getPassword().equals(password)){
            return new ResponseEntity<>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.NOT_FOUND);
        }
        TokenModel model = tokenManager.createToken(id);

        return new ResponseEntity<>(ResultModel.ok(model), HttpStatus.OK);
    }

/*

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ResultModel> login(@RequestParam String username, @RequestParam String password) {
        Assert.notNull(username, "username can not be empty");
        Assert.notNull(password, "password can not be empty");
*/

       // User user = userRepository.findByUsername(username);
       // if (user == null ||  //未注册
       //         !user.getPassword().equals(password)) {  //密码错误
            //提示用户名或密码错误
        //    return new ResponseEntity<>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.NOT_FOUND);
     //   }
        //生成一个token，保存用户登录状态

 /*       int userId =122601;
        TokenModel model = tokenManager.createToken(userId);
        return new ResponseEntity<>(ResultModel.ok(model), HttpStatus.OK);
    }*/

}
