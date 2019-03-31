package com.huawei.testMybatisXml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
@MapperScan("com.huawei.testMybatisXml.mapper")
public class TestMybatisXmlApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestMybatisXmlApplication.class, args);
	}
}
