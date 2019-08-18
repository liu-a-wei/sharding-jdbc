package com.liuawei.sharding.trade;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.liuawei.sharding.trade.model.UserOrder;
import com.liuawei.sharding.trade.service.UserOrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderApplicationTests {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderApplicationTests.class);

	@Autowired
	private UserOrderService userOrderService;
	
	private String[] userIdArr = { "1", "2", "3", "4", "5", "6", "7", "8"};

	@Test
	public void testInsertOrderShardingDb() {
		Random random = new Random();
		UserOrder userOrder = new UserOrder();
		for (int i = 1; i < 10; i++) {
			userOrder = new UserOrder();
			userOrder.setId(System.currentTimeMillis()+i);
			userOrder.setMchId("mchId"+i);
			userOrder.setOrderNo("orderNo"+i);
			userOrder.setSkuId("skuId"+i);
			userOrder.setTotalAmount(i*100);
			userOrder.setUserId(i);
			if (1 == userOrderService.insertOrder(userOrder)) {
				LOGGER.info("入库成功db_user_order,orderInfo={}", userOrder);
			} else {
				LOGGER.info("入库失败db_user_order,orderInfo={}", userOrder);
			}
		}
	}
	
}
