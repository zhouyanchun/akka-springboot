package com.huawei.testMybatisXml.domain;

public class Subnet {
    private Long id;
    private String name;
    private String networkId;
    private String deviceOwner;

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

    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public String getDeviceOwner() {
        return deviceOwner;
    }

    public void setDeviceOwner(String deviceOwner) {
        this.deviceOwner = deviceOwner;
    }
}
