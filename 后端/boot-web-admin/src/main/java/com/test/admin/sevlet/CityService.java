package com.test.admin.sevlet;

import com.test.admin.bean.City;
import com.test.admin.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    CityMapper cityMapper;

    public City getById(long id) {
        return cityMapper.getById(id);
    }

    public void savecity(City city) {
        cityMapper.insert(city);
    }
}
