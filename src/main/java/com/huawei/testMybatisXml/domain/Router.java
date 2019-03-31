package com.huawei.testMybatisXml.domain;

public class Router {
    private Long id;
    private String name;
    private String sgportId;
    private String exterNeworkId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSgportId() {
        return sgportId;
    }

    public void setSgportId(String sgportId) {
        this.sgportId = sgportId;
    }

    public String getExterNeworkId() {
        return exterNeworkId;
    }

    public void setExterNeworkId(String exterNeworkId) {
        this.exterNeworkId = exterNeworkId;
    }
}
