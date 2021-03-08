package com.test.admin.mapper;

import com.test.admin.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper //数据库接口都要加这个
public interface UserMapper {

    public User getUser(String Username);

}
