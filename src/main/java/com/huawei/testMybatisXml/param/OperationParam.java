package com.huawei.testMybatisXml.param;

import java.util.Map;

public class OperationParam {
    private String operation;
    Map<String, Object> params;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
