package com.huawei.testMybatisXml.akkaconfig;

import akka.actor.ActorSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.huawei.testMybatisXml.akkaconfig.SpringExtension.SPRING_EXTENSION_PROVIDER;

@Configuration
public class AkkaConfiguration {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public ActorSystem actorSystem() {
        ActorSystem actorSystem = ActorSystem.create("db_actorSystem");
        SPRING_EXTENSION_PROVIDER.get(actorSystem).initialize(applicationContext);
        return actorSystem;
    }
}
