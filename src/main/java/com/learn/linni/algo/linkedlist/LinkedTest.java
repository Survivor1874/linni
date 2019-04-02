package com.learn.linni.algo.linkedlist;
import java.util.Date;

import com.learn.linni.common.entity.user.User;
import org.junit.jupiter.api.Test;

/**
 * @author : linjun.li@quvideo.com
 * @date : 2019-03-27 16:01
 */

public class LinkedTest {

    @Test
    public void testLinkList() {
        SinglyLinkedList<User> linkedList = new SinglyLinkedList<>();
        User user01 = new User();
        user01.setId(1);
        user01.setUsername("01");
        user01.setBirthday(new Date());
        User user02 = new User();
        user02.setId(2);
        user02.setUsername("02");
        user02.setBirthday(new Date());
        User user03 = new User();
        user03.setId(3);
        user03.setUsername("03");
        user03.setBirthday(new Date());
        User user04 = new User();
        user04.setId(4);
        user04.setUsername("04");
        user04.setBirthday(new Date());


        linkedList.insertToHead(user01);
        linkedList.insertToTail(user02);
        linkedList.insertToHead(user03);
        linkedList.printAll();
        System.out.println("-----------------------------------------");
        linkedList.deleteByValue(user02);
        linkedList.printAll();
    }
}
