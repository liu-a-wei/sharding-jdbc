package com.liuawei.sharding.trade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuawei.sharding.trade.dao.UserOrderDao;
import com.liuawei.sharding.trade.model.UserOrder;

@Service
public class UserOrderServiceImpl implements UserOrderService{
	
	@Autowired
	private UserOrderDao userOrderDao;

	@Override
	public int insertOrder(UserOrder userOrder) {
		return userOrderDao.insertOrder(userOrder);
	}

}
