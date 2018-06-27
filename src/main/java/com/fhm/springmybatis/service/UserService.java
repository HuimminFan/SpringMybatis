package com.fhm.springmybatis.service;

import com.fhm.springmybatis.domain.User;

//是为了user模块有可能扩展的业务而加的这个接口
public interface UserService extends BaseService<User>{
    public void longTx();
}
