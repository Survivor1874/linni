package com.learn.linni.useful;

import com.alibaba.fastjson.JSON;
import com.learn.linni.common.entity.user.User;
import lombok.Data;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * @author : linjun.li@quvideo.com
 * @date : 2019-04-09 11:29
 */
@Data
public class ObjPool<T, R> {

    private final List<T> pool;

    /**
     * 用信号量实现限流器
     */
    private final Semaphore sem;

    /**
     * 构造函数
     *
     * @param size size
     * @param t    t
     */
    ObjPool(int size, T t) {
        pool = new Vector<T>() {
        };
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        sem = new Semaphore(size);
    }

    /**
     * 利用对象池的对象，调用 func
     *
     * @param func {@link Function}
     * @return R
     * @throws InterruptedException ie
     */
    R exec(Function<T, R> func) throws InterruptedException {
        T t = null;
        sem.acquire();
        try {
            t = pool.remove(0);
            return func.apply(t);
        } finally {
            pool.add(t);
            sem.release();
        }
    }

    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setUsername("fd");
        ObjPool objPool = new ObjPool(5, user);
        Object exec = objPool.exec(u -> {
            System.out.println(JSON.toJSONString(objPool.getSem()));
            return u.toString();
        });
        System.err.println(JSON.toJSONString(exec));
    }
}


