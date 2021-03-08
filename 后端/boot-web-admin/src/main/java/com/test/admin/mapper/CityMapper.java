package com.test.admin.mapper;

import com.test.admin.bean.City;
import com.test.admin.sevlet.CityService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

    @Select("select * from city where id=#{id}")
    public City getById(long id);

//    @Select("insert into city(name,state,country) values(#{name},#{state},#{country})")
    public void insert(City city);

}
