package cn.lerke.shading.order.model;

public class MachineOnlinePay {

	private String id;
	private Integer rootOrgId;
	private Long outOrderNo;
	private String payType;
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

	public Long getOutOrderNo() {
		return outOrderNo;
	}

	public void setOutOrderNo(Long outOrderNo) {
		this.outOrderNo = outOrderNo;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
