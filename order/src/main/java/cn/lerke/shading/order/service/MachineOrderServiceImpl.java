package cn.lerke.shading.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lerke.shading.order.dao.MachineOrderDao;
import cn.lerke.shading.order.model.MachineOrder;

@Service
public class MachineOrderServiceImpl implements MachineOrderService{
	
	@Autowired
	private MachineOrderDao machineOrderDao;

	public int insertMachineOrder(MachineOrder machineOrder) {
		return machineOrderDao.insertMachineOrder(machineOrder);
	}

}
