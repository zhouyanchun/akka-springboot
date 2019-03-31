package com.huawei.testMybatisXml.mapper;

import com.huawei.testMybatisXml.domain.Router;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface RouterMapper {
    List<Router> selectCondition(Map router);
}
