package com.didispace.chapter23;

import javax.validation.Valid;

/**
 * 不生效
 */
public class MyUtil {

    public static void increAge(User user){
        @Valid User user2 = user;
        user2.setAge(11);
    }

    public static void increAge2(@Valid User user){
        user.setAge(12);

    }

}
