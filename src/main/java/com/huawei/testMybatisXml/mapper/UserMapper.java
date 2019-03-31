package com.huawei.testMybatisXml.mapper;

import com.huawei.testMybatisXml.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface UserMapper {
    ArrayList<User> getAll();
    User getOne(Long id);
}
