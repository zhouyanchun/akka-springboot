package com.huawei.testMybatisXml.enmus;

public enum ResourceActorEnum {
    subnet("subnetHandleActor", "subnet资源"),
    router("routerHandleActor", "router资源"),
    ;
    private String actorHandle;
    private String desc;
    private ResourceActorEnum(String actorHandle, String desc){
        this.actorHandle = actorHandle;
        this.desc = desc;
    }

    public String getActorHandle() {
        return actorHandle;
    }

    public String getDesc() {
        return desc;
    }
}
