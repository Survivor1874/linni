package com.learn.linni.controllor;



import com.learn.linni.common.entity.user.User;
import com.learn.linni.dao.UserMapper;
import com.learn.linni.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;








    @GetMapping("/test")
    public String test(){
      //  return "aaa";
       return getHellow();
    }

    public String getHellow(){
        return "2345";
    }



   @RequestMapping(value="/selectById/{id}",method = RequestMethod.GET ,produces =  "application/json")
    public User  selectById(@PathVariable("id") int id){
       //  Integer  id = 29;
        User user = userService.selectById(id);
        return user;
    }



}
