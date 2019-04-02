package com.learn.linni.common.entity.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linjun.li@quvideo.com
 * @date 2018-12-21 15:58
 **/
@Data
@EqualsAndHashCode
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer password;

    private String username;

    private Date birthday;

    private String sex;

    private String address;


}
