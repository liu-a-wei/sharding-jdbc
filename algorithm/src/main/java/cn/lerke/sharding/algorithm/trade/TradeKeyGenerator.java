package cn.lerke.sharding.algorithm.trade;

public class TradeKeyGenerator {

	/**
	 * 生成交易自定义主键
	 * 
	 * @param shardingTradeEnum
	 * @param machineCode
	 * @return
	 * 
	 * 001156571209167651800015
	 */
	public static String generateKey(ShardingTradeEnum shardingTradeEnum, String machineCode) {
		StringBuffer key = new StringBuffer();
		key.append(shardingTradeEnum.getIdentification());
		key.append(shardingTradeEnum.getVersion());
		key.append(System.currentTimeMillis());
		key.append(machineCode);
		// 增加redis序列号
		return key.toString();
	}

	
	public static void main(String [] args){
		System.out.print(generateKey(ShardingTradeEnum.TRADE_ORDER,"51800015"));
	}
}
