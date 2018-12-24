package com.learn.linni.dao;

import com.learn.linni.common.entity.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author linjun.li@quvideo.com
 * @date 2018-12-21 15:55
 **/

@Repository
public interface UserMapper {

    User selectById(Integer   userId);

    /**
     * 以集合的方式,往User表里插入数据
     * @param list 要插入到User集合
     * @return 插入成功的数量
     */
    Integer insterList(List<User> list);
    Integer testInsertList(List<User> list);

    /**
     * 修改User
     * @param user 要修改的User值
     * @return 修改成功的数量
     */
    Integer updateByUser(User user);
    Integer testUpdateByUser(User user);

    /**
     * 插入一个User数据
     * @param user 要插入的数据
     * @return 插入成功的数量
     */
    Integer insertUser(User user);
    Integer testInsertUser(User user);

    /**
     * 查询符合条件的User
     * @param user 条件
     * @return 符合条件的User
     */
    List<User> testByUser(User user);

}
