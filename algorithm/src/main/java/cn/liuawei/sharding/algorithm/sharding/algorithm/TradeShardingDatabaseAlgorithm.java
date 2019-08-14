package cn.liuawei.sharding.algorithm.sharding.algorithm;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import cn.liuawei.sharding.algorithm.sharding.ShardingConstant;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

public class TradeShardingDatabaseAlgorithm implements PreciseShardingAlgorithm<Integer> {

	private static Logger logger = LoggerFactory.getLogger(TradeShardingDatabaseAlgorithm.class);

	@Override
	public String doSharding(Collection<String> databases, PreciseShardingValue<Integer> shardingValue) {
		logger.info("availableTargetNames:{},shardingValue:{}", JSON.toJSONString(databases),
				JSON.toJSON(shardingValue));
		// availableTargetNames:["order0","order1"],
		// shardingValue:{"logicTableName":"machine_order","value":2,"columnName":"root_org_id"}
		for (String db : databases) {
			if (db.endsWith(String.valueOf(shardingValue.getValue() % ShardingConstant.TABLE_NUM))) {
				return db;
			}
		}
		return null;
	}

}
