package com.fhm.springmybatis.test;

import com.fhm.springmybatis.domain.Item;
import com.fhm.springmybatis.domain.Order;
import com.fhm.springmybatis.domain.User;
import com.fhm.springmybatis.service.ItemService;
import com.fhm.springmybatis.service.OrderService;
import com.fhm.springmybatis.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.List;

public class testConn {
    @Test
    public void testconn() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        DataSource ds = (DataSource) ac.getBean("dataSource");
        System.out.print(ds.getConnection());
    }
    @Test
    public void testUserService() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        UserService us = (UserService)ac.getBean("userService");
        User u = new User();
        u.setName("Mary");
        u.setAge(19);
        us.insert(u);
    }
    @Test
    public void testUserService1() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        UserService us = (UserService)ac.getBean("userService");
        List<User> list = us.selectAll();
        for(User u : list){
            System.out.println(u.getName()+":"+u.getAge());
        }

    }
    @Test
    public void testUserService2() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        UserService us = (UserService)ac.getBean("userService");
        User u = us.selectOne(1);
        System.out.println(u.getName()+":"+u.getAge());

    }
    @Test
    public void testOrderService() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        OrderService os = (OrderService)ac.getBean("orderService");
        User u = new User();
        Order o =new Order();
        o.setOrderNo("No007");
        o.setUser(u);
        os.insert(o);
    }
    @Test
    public void testItemService() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        ItemService is = (ItemService)ac.getBean("itemService");
        Item i = is.selectOne(1);
        System.out.println(i.getItemName());
        System.out.println(i.getOrder().getOrderNo());
        System.out.println(i.getOrder().getUser().getName());

    }
}
