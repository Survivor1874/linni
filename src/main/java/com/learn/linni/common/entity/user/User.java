package com.learn.linni.common.entity.user;

import lombok.Data;

import java.util.Date;

/**
 * @author linjun.li@quvideo.com
 * @date 2018-12-21 15:58
 **/
@Data
public class User {

    private Integer id;

    private String username;

    private Date birthday;

    private String sex;

    private String address;


}
