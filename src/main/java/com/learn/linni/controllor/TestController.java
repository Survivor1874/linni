package com.learn.linni.controllor;



import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class TestController {

    @GetMapping("/test")
    public String test(){
      //  return "aaa";
       return getHellow();
    }

    public String getHellow(){
        return "2345";
    }


}
