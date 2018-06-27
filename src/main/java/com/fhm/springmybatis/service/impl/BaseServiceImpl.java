package com.fhm.springmybatis.service.impl;

import com.fhm.springmybatis.dao.BaseDao;
import com.fhm.springmybatis.service.BaseService;

import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    private BaseDao<T> dao;

    //这儿给dao加set方法，主要是为了让她的子类UserServiceImpl等通过重写dao的set方法时完成注入
    public void setDao(BaseDao<T> dao) {
        this.dao = dao;
    }


    public void insert(T t) {
        dao.insert(t);
    }

    public void update(T t) {
        dao.update(t);
    }

    public void delete(Integer id) {
        dao.delete(id);
        throw new RuntimeException("出错啦！！") ;
    }

    public T selectOne(Integer id) {
        return dao.selectOne(id);
    }

    public List<T> selectAll() {
        return dao.selectAll();
    }
}
