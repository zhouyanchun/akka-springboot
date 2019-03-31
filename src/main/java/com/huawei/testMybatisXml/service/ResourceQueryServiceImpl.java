package com.huawei.testMybatisXml.service;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.pattern.Patterns;
import akka.util.Timeout;
import com.alibaba.fastjson.JSON;
import com.huawei.testMybatisXml.akkaconfig.SpringExtension;
import com.huawei.testMybatisXml.dto.ResponseDto;
import com.huawei.testMybatisXml.param.ResourceParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.FiniteDuration;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class ResourceQueryServiceImpl implements ResourceQueryService {
    private static Logger logger = LoggerFactory.getLogger(ResourceQueryServiceImpl.class);
    @Autowired
    private ActorSystem actorSystem;

    @Override
    public ResponseDto listResource(ResourceParam resourceParam) {
//        logger.info("############ResourceQueryService address = {}", this);
        logger.info("#####################thread start {}-{}", Thread.currentThread().getId(), Thread.currentThread().getName() );
        String actorName = resourceParam.getResouceType().getActorHandle();

        ActorRef actorRef = actorSystem.actorOf(SpringExtension.SPRING_EXTENSION_PROVIDER.get(actorSystem)
                .props(actorName), actorName + UUID.randomUUID());
//        actorRef.tell(resourceParam.getOperationParam(), );
//        PatternsCS.ask()
        long start = System.currentTimeMillis();

        FiniteDuration duration = FiniteDuration.create(120, TimeUnit.SECONDS);
        Timeout timeout = Timeout.durationToTimeout(duration);
        Future<Object> result = Patterns.ask(actorRef, resourceParam.getOperationParam(), timeout);
        try {
            Object result1 = Await.result(result, duration);
            logger.info("######################## actor take time : {}", (System.currentTimeMillis() - start));
            return (ResponseDto) result1;
        } catch (Exception e) {
            logger.error("wait result excption: {}", JSON.toJSONString(resourceParam), e);
            return ResponseDto.buildFail(ResponseDto.OPERATION_NOT_FOUND, "wait result exception");
        }
    }
}
