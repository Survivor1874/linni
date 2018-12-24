package com.learn.linni.controllor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tests/")
public class TestCotorllor {
    @RequestMapping("test")
    public String  test(){
        return "lalala";
    }
}
