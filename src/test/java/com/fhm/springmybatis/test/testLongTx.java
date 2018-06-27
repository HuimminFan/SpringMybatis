package com.fhm.springmybatis.test;

import com.fhm.springmybatis.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testLongTx {
    @Test
    public void testlonttx() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        UserService us = (UserService) ac.getBean("userService") ;
        us.longTx();

    }

}
