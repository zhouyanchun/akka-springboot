package com.huawei.testMybatisXml.service;

import com.huawei.testMybatisXml.dto.ResponseDto;
import com.huawei.testMybatisXml.param.ResourceParam;

import java.util.List;

public interface ResourceQueryService {
    ResponseDto listResource(ResourceParam resourceParam);
}
