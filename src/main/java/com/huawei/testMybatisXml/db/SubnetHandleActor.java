package com.huawei.testMybatisXml.db;

import akka.actor.UntypedAbstractActor;
import com.huawei.testMybatisXml.domain.Subnet;
import com.huawei.testMybatisXml.dto.ResponseDto;
import com.huawei.testMybatisXml.mapper.SubnetMapper;
import com.huawei.testMybatisXml.param.OperationParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SubnetHandleActor extends UntypedAbstractActor {
    private static final Logger logger = LoggerFactory.getLogger(SubnetHandleActor.class);

    @Autowired
    private SubnetMapper subnetMapper;

    @Override
    public void onReceive(Object o) throws Throwable {
        ResponseDto responseDto = ResponseDto.buildFail(ResponseDto.ERROR_MESSAGE_TYPE, "无法识别的消息类型");
        if (o instanceof OperationParam) {
            OperationParam operationParam = (OperationParam) o;
            List<Subnet> subnets = Collections.EMPTY_LIST;
            switch (operationParam.getOperation()) {
                case "list":
                    subnets = subnetMapper.selectCondition(operationParam.getParams());
                    responseDto = ResponseDto.buildSuccess(subnets);
                    break;
                case "show":
                    subnets = subnetMapper.selectCondition(operationParam.getParams());
                    Subnet subnet = null;
                    if (!CollectionUtils.isEmpty(subnets)) {
                        subnet = subnets.get(0);
                    }
                    responseDto = ResponseDto.buildSuccess(subnet);
                    break;
                 default:
            }
        } else {
            logger.error("sorry cc, subnetHandleActor can't handle this message type");
        }
        sender().tell(responseDto, self());
    }
}
