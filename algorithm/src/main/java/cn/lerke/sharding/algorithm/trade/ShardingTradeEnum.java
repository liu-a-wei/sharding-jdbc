package cn.lerke.sharding.algorithm.trade;

/**
 * 业务表示
 * 
 * @author lenovo
 *
 */
public enum ShardingTradeEnum {

	

	TRADE_ORDER("00", "1", "交易订单"),

	TRADE_PAY("01", "1", "交易流水");

	/** 业务表示 */
	private String identification;
	/** 版本 */
	private String version;
	/** 描述 */
	private String desc;

	ShardingTradeEnum(String identification, String version, String desc) {
		this.identification = identification;
		this.version = version;
		this.desc = desc;
	}

	public String getIdentification() {
		return identification;
	}

	public String getVersion() {
		return version;
	}

	public String getDesc() {
		return desc;
	}

}
