package com.liuawei.sharding.trade.model;

import java.util.Date;

public class UserOrder {

	private Long id;
	private Integer totalAmount;
	private String orderNo;
	private Integer userId;
	private String mchId;
	private String skuId;
	private Date orderTime;
	private Date gmtModified;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getMchId() {
		return mchId;
	}
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
	public String getSkuId() {
		return skuId;
	}
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	@Override
	public String toString() {
		return "UserOrder [id=" + id + ", totalAmount=" + totalAmount + ", orderNo=" + orderNo + ", userId=" + userId
				+ ", mchId=" + mchId + ", skuId=" + skuId + ", orderTime=" + orderTime + ", gmtModified=" + gmtModified
				+ "]";
	}

}
