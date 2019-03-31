package com.huawei.testMybatisXml;

import com.alibaba.fastjson.JSON;
import com.huawei.testMybatisXml.domain.Subnet;
import com.huawei.testMybatisXml.dto.ResponseDto;
import com.huawei.testMybatisXml.enmus.ResourceActorEnum;
import com.huawei.testMybatisXml.entity.User;
import com.huawei.testMybatisXml.mapper.RouterMapper;
import com.huawei.testMybatisXml.mapper.SubnetMapper;
import com.huawei.testMybatisXml.mapper.UserMapper;
import com.huawei.testMybatisXml.param.OperationParam;
import com.huawei.testMybatisXml.param.ResourceParam;
import com.huawei.testMybatisXml.service.ResourceQueryService;
import jdk.management.resource.ResourceType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestMybatisXmlApplication.class)
@WebAppConfiguration
public class TestMybatisXmlApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private SubnetMapper subnetMapper;

	@Autowired
	private RouterMapper routerMapper;

	@Autowired
	private ResourceQueryService resourceQueryService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void printUsers() {
		User user = userMapper.getOne(3L);
		System.out.println("name = " + user.getName() + ", age = " + user.getAge());

		ArrayList<User> arrayList = userMapper.getAll();
		for(int  i = 0; i < arrayList.size(); i++) {
			user = arrayList.get(i);
			System.out.println("id = " + user.getId() + ", name = " + user.getName() + ", age = " + user.getAge());

		}
	}

	@Test
	public void getSubnets() {
		HashMap dbParams = new HashMap();
		dbParams.put("id", 1);
		List<Subnet> subnets = subnetMapper.selectCondition(dbParams);
		System.out.println(JSON.toJSONString(subnets));

		ResourceParam resourceParam = new ResourceParam();
		resourceParam.setResouceType(ResourceActorEnum.subnet);
		//service
	}


	@Test
	public void resourceQueryServiceTest() throws InterruptedException {
		ResourceParam resourceParam = new ResourceParam();
		resourceParam.setResouceType(ResourceActorEnum.subnet);
		OperationParam operationParam = new OperationParam();
		operationParam.setOperation("list");
		Map param = new HashMap();
		param.put("name", "kai_1");
		operationParam.setParams(param);
		resourceParam.setOperationParam(operationParam);

		ResponseDto responseDto = resourceQueryService.listResource(resourceParam);
		System.out.println(JSON.toJSONString(responseDto));

	}

}
