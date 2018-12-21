package com.learn.linni.dao;

import com.learn.linni.common.entity.user.User;
import org.springframework.stereotype.Repository;

/**
 * @author linjun.li@quvideo.com
 * @date 2018-12-21 15:55
 **/

@Repository
public interface UserMapper {

    User selectById(Integer   userId);

}
