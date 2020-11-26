package com.didispace.chapter23;

import javax.validation.Valid;

/**
 * 不生效
 */
public interface MyService {

    void increAge(User user);

    void increAge2(@Valid User user);

}
