package com.fhm.springmybatis.service.impl;

import com.fhm.springmybatis.dao.BaseDao;
import com.fhm.springmybatis.domain.Item;
import com.fhm.springmybatis.domain.Order;
import com.fhm.springmybatis.domain.User;
import com.fhm.springmybatis.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//使用注解来配置bean
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
    @Resource(name="itemDaoImpl")
    private BaseDao<Item> itemDao ;

    //通过重写set方法来给service的dao属性注入值，即注入指定的dao对象

    @Resource(name = "userDaoImpl")
    public void setDao(BaseDao<User> dao){
        super.setDao(dao);
    }

    //长事务
    public void longTx(){
        //给2号用户插入新的item
        Item i = new Item();
        i.setItemName("fhsj");
        Order o = new Order();
        o.setId(2);
        i.setOrder(o);

        itemDao.insert(i);

        //删除2号user
        this.delete(2);

    }

}
