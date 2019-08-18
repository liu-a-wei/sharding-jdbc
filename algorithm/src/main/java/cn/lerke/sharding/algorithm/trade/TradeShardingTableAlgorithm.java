package cn.lerke.sharding.algorithm.trade;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

public class TradeShardingTableAlgorithm implements PreciseShardingAlgorithm<Integer> {

	private static Logger logger = LoggerFactory.getLogger(TradeShardingTableAlgorithm.class);

	@Override
	public String doSharding(Collection<String> tableNames, PreciseShardingValue<Integer> shardingValue) {
		logger.info("tableNames:{},shardingValue:{}", JSON.toJSONString(tableNames), JSON.toJSON(shardingValue));
		// availableTargetNames:["order0","order1"],
		// shardingValue:{"logicTableName":"machine_order","value":2,"columnName":"root_org_id"}
		for (String db : tableNames) {
			if (db.endsWith(
					String.valueOf(shardingValue.getValue() / ShardingConstant.DB_NUM % ShardingConstant.TABLE_NUM))) {
				return db;
			}
		}
		return null;
	}

}
