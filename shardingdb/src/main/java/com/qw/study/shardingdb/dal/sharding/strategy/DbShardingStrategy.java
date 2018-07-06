package com.qw.study.shardingdb.dal.sharding.strategy;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;
import com.google.common.collect.Range;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * @author qunar-qw
 * @date 18-7-5
 */
public class DbShardingStrategy implements SingleKeyDatabaseShardingAlgorithm<Integer> {

    @Override public String doEqualSharding(Collection<String> availableTargetNames,
            ShardingValue<Integer> shardingValue) {
        for (String dbName : availableTargetNames) {
            String dbSign = String.valueOf(shardingValue.getValue() % 2) + "";
            if(dbName.endsWith(dbSign)) {
                return dbName;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override public Collection<String> doInSharding(Collection<String> availableTargetNames,
            ShardingValue<Integer> shardingValue) {
        return null;
    }

    @Override public Collection<String> doBetweenSharding(Collection<String> availableTargetNames,
            ShardingValue<Integer> shardingValue) {
        return null;
    }
}
