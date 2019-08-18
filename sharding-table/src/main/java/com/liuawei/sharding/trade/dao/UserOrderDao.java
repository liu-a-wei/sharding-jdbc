package com.liuawei.sharding.trade.dao;

import org.apache.ibatis.annotations.Insert;

import com.liuawei.sharding.trade.model.UserOrder;

public interface UserOrderDao {

	 @Insert("INSERT INTO user_order (id,order_no,user_id,mch_id,sku_id,total_amount) "
	 		+ "	VALUES (#{id},#{orderNo},#{userId},#{mchId},#{skuId},#{totalAmount})")
	 int insertOrder(UserOrder userOrder);
}
