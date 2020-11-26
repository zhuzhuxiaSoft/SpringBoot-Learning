package com.didispace.chapter23;

import org.springframework.stereotype.Service;

import javax.validation.Valid;

/**
 * 不生效
 */
@Service
public class MyServiceImpl implements  MyService{

    public void increAge(User user){
        @Valid User user2 = user;
        user2.setAge(11);
    }

    public void increAge2(@Valid User user){
        user.setAge(12);

    }

}
