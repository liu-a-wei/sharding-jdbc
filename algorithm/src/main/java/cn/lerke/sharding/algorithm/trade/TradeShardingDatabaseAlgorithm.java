package cn.lerke.sharding.algorithm.trade;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

public class TradeShardingDatabaseAlgorithm implements PreciseShardingAlgorithm<Integer> {

	private static Logger logger = LoggerFactory.getLogger(TradeShardingDatabaseAlgorithm.class);

	@Override
	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Integer> shardingValue) {
		logger.info("availableTargetNames:{},shardingValue:{}", JSON.toJSONString(availableTargetNames),
				JSON.toJSON(shardingValue));
		for (String db : availableTargetNames) {
			if (db.endsWith(String.valueOf(shardingValue.getValue() % ShardingConstant.DB_NUM))) {
				return db;
			}
		}
		return null;
	}

}
