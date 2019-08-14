package cn.lerke.shading.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lerke.shading.order.dao.MachineOnlinePayDao;
import cn.lerke.shading.order.model.MachineOnlinePay;

@Service
public class MachineOnlinePayServiceImpl implements MachineOnlinePayService {

	@Autowired
	private MachineOnlinePayDao machineOnlinePayDao;

	@Override
	public int insertMachineOnlinePay(MachineOnlinePay machineOnlinePay) {
		return machineOnlinePayDao.insertMachineOnlinePay(machineOnlinePay);
	}

}
