package com.huawei.testMybatisXml.mapper;

import com.huawei.testMybatisXml.domain.Subnet;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface  SubnetMapper {
    List<Subnet> selectCondition(Map map);
}
