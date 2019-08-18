package cn.lerke.shading.order;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.lerke.shading.order.model.MachineOnlinePay;
import cn.lerke.shading.order.model.MachineOrder;
import cn.lerke.shading.order.service.MachineOnlinePayServiceImpl;
import cn.lerke.shading.order.service.MachineOrderServiceImpl;
import cn.lerke.shading.order.sharding.ShardingTradeEnum;
import cn.lerke.shading.order.sharding.TradeKeyGenerator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderApplicationTests {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderApplicationTests.class);

	@Autowired
	private MachineOrderServiceImpl machineOrderServiceImpl;
	@Autowired
	private MachineOnlinePayServiceImpl machineOnlinePayServiceImpl;
	
	private String[] orgIdArr = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
			"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32" };

	@Test
	public void testInsertMachineOrder() {
		Random random = new Random();
		for (int i = 0; i < 1; i++) {
			MachineOrder orderInfo = new MachineOrder();
			orderInfo.setUserName("username:"+i);
			orderInfo.setRootOrgId(Integer.valueOf(orgIdArr[random.nextInt(32)]));
			orderInfo.setOrderId(i);
			orderInfo.setId(TradeKeyGenerator.generateKey(ShardingTradeEnum.TRADE_ORDER, "51800000"));
			int result = machineOrderServiceImpl.insertMachineOrder(orderInfo);
			if (1 == result) {
				LOGGER.info("入库成功,orderInfo={}", orderInfo);
			} else {
				LOGGER.info("入库失败,orderInfo={}", orderInfo);
			}
		}
	}
	
	@Test
	public void testInsertMachineOnlinePay() {
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			MachineOnlinePay orderInfo = new MachineOnlinePay();
			orderInfo.setUserName("username:"+i);
			orderInfo.setRootOrgId(Integer.valueOf(orgIdArr[random.nextInt(32)]));
			orderInfo.setOutOrderNo((long)i);
			orderInfo.setPayType("paytype");
			orderInfo.setId(TradeKeyGenerator.generateKey(ShardingTradeEnum.TRADE_PAY, "51800000"));
			int result = machineOnlinePayServiceImpl.insertMachineOnlinePay(orderInfo);
			
			if (1 == result) {
				LOGGER.info("入库成功,orderInfo={}", orderInfo);
			} else {
				LOGGER.info("入库失败,orderInfo={}", orderInfo);
			}
		}
	}
	
	@Test
	public void saveOrder(){
		MachineOrder machineOrder = new MachineOrder();
		machineOrder.setUserName("username:"+System.currentTimeMillis());
		machineOrder.setRootOrgId(1);
		machineOrder.setOrderId(0515);
		machineOrder.setId(TradeKeyGenerator.generateKey(ShardingTradeEnum.TRADE_ORDER, "51800000"));
		
		MachineOnlinePay machineOnlinePay = new MachineOnlinePay();
		machineOnlinePay.setUserName("username:"+System.currentTimeMillis());
		machineOnlinePay.setRootOrgId(2);
		machineOnlinePay.setOutOrderNo(987654321L);
		machineOnlinePay.setPayType("paytype");
		machineOnlinePay.setId(TradeKeyGenerator.generateKey(ShardingTradeEnum.TRADE_PAY, "51800000"));
		
		machineOrderServiceImpl.saveOrder(machineOrder, machineOnlinePay);
	}
	
	@Test
	public void saveOrderFailByLocal(){
		MachineOrder machineOrder = new MachineOrder();
		Long time = System.currentTimeMillis();
		machineOrder.setUserName("username:local:"+time);
		machineOrder.setRootOrgId(1);
		machineOrder.setOrderId(987654321);
		machineOrder.setId(TradeKeyGenerator.generateKey(ShardingTradeEnum.TRADE_ORDER, "51800000"));
		
		MachineOnlinePay machineOnlinePay = new MachineOnlinePay();
		machineOnlinePay.setUserName("username:local:"+time);
		machineOnlinePay.setRootOrgId(2);
		machineOnlinePay.setOutOrderNo(System.currentTimeMillis());
		machineOnlinePay.setPayType("paytype");
		machineOnlinePay.setId(TradeKeyGenerator.generateKey(ShardingTradeEnum.TRADE_PAY, "51800000"));
		
		machineOrderServiceImpl.saveOrderFailByLocal(machineOrder, machineOnlinePay);
	}
	
	@Test
	public void saveOrderFailByXa(){
		MachineOrder machineOrder = new MachineOrder();
		Long time = System.currentTimeMillis();
		machineOrder.setUserName("username:xa:"+time);
		machineOrder.setRootOrgId(1);
		machineOrder.setOrderId(0515);
		machineOrder.setId(TradeKeyGenerator.generateKey(ShardingTradeEnum.TRADE_ORDER, "51800000"));
		
		MachineOnlinePay machineOnlinePay = new MachineOnlinePay();
		machineOnlinePay.setUserName("username:xa:"+time);
		machineOnlinePay.setRootOrgId(2);
		machineOnlinePay.setOutOrderNo(987654321L);
		machineOnlinePay.setPayType("paytype");
		machineOnlinePay.setId(TradeKeyGenerator.generateKey(ShardingTradeEnum.TRADE_PAY, "51800000"));
		
		machineOrderServiceImpl.saveOrderFailByXa(machineOrder, machineOnlinePay);
	}
	
}
