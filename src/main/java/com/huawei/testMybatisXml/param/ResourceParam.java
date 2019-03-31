package com.huawei.testMybatisXml.param;

import com.huawei.testMybatisXml.enmus.ResourceActorEnum;

import java.util.Map;

public class ResourceParam {
    private ResourceActorEnum resouceType;
    private OperationParam operationParam;

    public OperationParam getOperationParam() {
        return operationParam;
    }

    public void setOperationParam(OperationParam operationParam) {
        this.operationParam = operationParam;
    }

    public ResourceActorEnum getResouceType() {
        return resouceType;
    }

    public void setResouceType(ResourceActorEnum resouceType) {
        this.resouceType = resouceType;
    }

}