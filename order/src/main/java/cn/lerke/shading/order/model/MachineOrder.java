package cn.lerke.shading.order.model;

public class MachineOrder {

	private String id;
	private Integer rootOrgId;
	private Integer orderId;
	private String userName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getRootOrgId() {
		return rootOrgId;
	}

	public void setRootOrgId(Integer rootOrgId) {
		this.rootOrgId = rootOrgId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
