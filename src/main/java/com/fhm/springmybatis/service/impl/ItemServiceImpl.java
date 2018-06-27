package com.fhm.springmybatis.service.impl;

import com.fhm.springmybatis.dao.BaseDao;
import com.fhm.springmybatis.domain.Item;
import com.fhm.springmybatis.domain.Order;
import com.fhm.springmybatis.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//使用注解来配置bean
@Service("itemService")
public class ItemServiceImpl extends BaseServiceImpl<Item> implements ItemService{
//    @Resource(name="itemDaoImpl")
//    private BaseDao<Item> itemDao ;

    //通过重写set方法来给service的dao属性注入值，即注入指定的dao对象

    @Resource(name = "itemDaoImpl")
    public void setDao(BaseDao<Item> dao){
        super.setDao(dao);
    }

    //长事务
    public void longTx(){
        //给2号用户插入新的item,l,
        Item i = new Item();
        i.setItemName("fhsj");
        Order o = new Order();
        o.setId(2);
        i.setOrder(o);

//        itemDao.insert(i);

        //删除2号user
        this.delete(2);

    }

}
