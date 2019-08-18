package cn.lerke.shading.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lerke.shading.order.dao.MachineOnlinePayDao;
import cn.lerke.shading.order.dao.MachineOrderDao;
import cn.lerke.shading.order.model.MachineOnlinePay;
import cn.lerke.shading.order.model.MachineOrder;
import io.shardingsphere.transaction.annotation.ShardingTransactionType;
import io.shardingsphere.transaction.api.TransactionType;

@Service
public class MachineOrderServiceImpl implements MachineOrderService {

	@Autowired
	private MachineOrderDao machineOrderDao;
	@Autowired
	private MachineOnlinePayDao machineOnlinePayDao;

	public int insertMachineOrder(MachineOrder machineOrder) {
		return machineOrderDao.insertMachineOrder(machineOrder);
	}

	public int saveOrder(MachineOrder machineOrder, MachineOnlinePay machineOnlinePay) {
		machineOrderDao.insertMachineOrder(machineOrder);
		machineOnlinePayDao.insertMachineOnlinePay(machineOnlinePay);
		return 0;
	}

	@Transactional
	@ShardingTransactionType(TransactionType.LOCAL)
	public int saveOrderFailByLocal(MachineOrder machineOrder, MachineOnlinePay machineOnlinePay) {
		machineOrderDao.insertMachineOrder(machineOrder);
		machineOnlinePayDao.insertMachineOnlinePay(machineOnlinePay);
		return 1/0;
	}

	@Transactional
	@ShardingTransactionType(TransactionType.XA)
	public int saveOrderFailByXa(MachineOrder machineOrder, MachineOnlinePay machineOnlinePay) {
		machineOrderDao.insertMachineOrder(machineOrder);
		machineOnlinePayDao.insertMachineOnlinePay(machineOnlinePay);
		return 1/0;
	}

}
