package com.huawei.testMybatisXml.db;

import akka.actor.UntypedAbstractActor;
import com.alibaba.fastjson.JSON;
import com.huawei.testMybatisXml.domain.Router;
import com.huawei.testMybatisXml.domain.Subnet;
import com.huawei.testMybatisXml.dto.ResponseDto;
import com.huawei.testMybatisXml.mapper.RouterMapper;
import com.huawei.testMybatisXml.param.OperationParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RouterHandleActor extends UntypedAbstractActor {
    private static Logger logger = LoggerFactory.getLogger(RouterHandleActor.class);
    @Autowired
    private RouterMapper routerMapper;

    @Override
    public void onReceive(Object o) throws Throwable {
        logger.info("################RouterHandleActor recive message = {}, msg class = {}",
                JSON.toJSONString(o), o.getClass());
        ResponseDto responseDto = ResponseDto.buildFail(ResponseDto.ERROR_MESSAGE_TYPE, "message type is not correct");
        if (o instanceof OperationParam) {
            OperationParam operationParam = (OperationParam) o;
            List<Router> routers = null;
            switch (operationParam.getOperation()) {
                case "list":
                    routers = routerMapper.selectCondition(operationParam.getParams());
                    responseDto = ResponseDto.buildSuccess(routers);
                    break;
                case "show":
                    routers = routerMapper.selectCondition(operationParam.getParams());
                    Router router = null;
                    if (!CollectionUtils.isEmpty(routers)) {
                        router = routers.get(0);
                    }
                    responseDto = ResponseDto.buildSuccess(router);
                    break;
                default:
            }
        } else {
            logger.error("sorry, subnetHandleActor can't handle this message type params = {}",JSON.toJSONString(o));
        }

        getContext().sender().tell(responseDto, getSelf());

    }


}
