package com.fhm.springmybatis.service.impl;

import com.fhm.springmybatis.dao.BaseDao;
import com.fhm.springmybatis.domain.Order;
import com.fhm.springmybatis.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//使用注解来配置bean
@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {

    //通过重写set方法来给service的dao属性注入值，即注入指定的dao对象
    @Resource(name = "orderDaoImpl")
    public void setDao(BaseDao<Order> dao){
        super.setDao(dao);
    }
}
