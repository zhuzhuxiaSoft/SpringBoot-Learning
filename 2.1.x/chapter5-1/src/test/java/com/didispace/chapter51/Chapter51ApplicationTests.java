package com.didispace.chapter51;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter51ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    private static UserRepository userRepository2;



    @Autowired
    private CacheManager cacheManager;

    private static CacheManager cacheManager2;

    @Test
    public void test() throws Exception {

        userRepository2 = userRepository;
        cacheManager2 = cacheManager;


                // 创建1条记录
        userRepository2.save(new User("CCC", 10));

        new Thread(Chapter51ApplicationTests::single, "a").start();
        new Thread(Chapter51ApplicationTests::single, "b").start();

        Thread.sleep(10*1_000);

    }


    public static void single() {

        System.out.println("CacheManager type : " + cacheManager2.getClass());

        try {
            Thread.sleep((long) (Math.random()*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        User u1 = userRepository2.findByName("CCC");
        System.out.println(Thread.currentThread().getName() + "第一次查询：" + u1.getAge());


        User u2 = userRepository2.findByName("CCC");
        System.out.println(Thread.currentThread().getName() + "第二次查询：" + u2.getAge());
    }



}
