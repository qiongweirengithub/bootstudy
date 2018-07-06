package com.qw.study.shardingdb.dal.sharding.strategy;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
import com.google.common.collect.Range;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * @author qunar-qw
 * @date 18-7-5
 */
public class MyTableShardingStrategy implements SingleKeyTableShardingAlgorithm<String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyTableShardingStrategy.class);

    @Override public String doEqualSharding(Collection<String> availableTargetNames,
            ShardingValue<String> shardingValue) {
        LOGGER.info("定位表后缀");
        for (String each : availableTargetNames) {
            char orderSign = shardingValue.getValue().toCharArray()[shardingValue.getValue().length()-1];
            int tableNum = Integer.valueOf(String.valueOf(orderSign)) % 2;
            if (each.endsWith(tableNum + "")) {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override public Collection<String> doInSharding(Collection<String> availableTargetNames,
            ShardingValue<String> shardingValue) {
        LOGGER.info("=======================================");
        Collection<String> result = new LinkedHashSet<>(availableTargetNames.size());
        return null;
    }

    @Override public Collection<String> doBetweenSharding(Collection<String> availableTargetNames,
            ShardingValue<String> shardingValue) {
        LOGGER.info("=======================================");
        Collection<String> result = new LinkedHashSet<>(availableTargetNames.size());
        return null;
    }
}


//
//
//
//    @Override public String doEqualSharding(Collection<String> tableNames, ShardingValue<Long> shardingValue) {
//        LOGGER.info("=======================================");
//        for (String each : tableNames) {
//            if (each.endsWith(shardingValue.getValue() % 2 + "")) {
//                return each;
//            }
//        }
//        throw new IllegalArgumentException();
//    }
//
//    @Override public Collection<String> doInSharding(Collection<String> tableNames, ShardingValue<Long> shardingValue) {
//        Collection<String> result = new LinkedHashSet<>(tableNames.size());
//        LOGGER.info("=======================================");
//
//        for (Long value : shardingValue.getValues()) {
//            for (String tableName : tableNames) {
//                if (tableName.endsWith(value % 2 + "")) {
//                    result.add(tableName);
//                }
//            }
//        }
//        return result;
//    }
//
//    @Override public Collection<String> doBetweenSharding(Collection<String> tableNames, ShardingValue<Long> shardingValue) {
//        Collection<String> result = new LinkedHashSet<>(tableNames.size());
//        LOGGER.info("=======================================");
//
//        Range<Long> range = shardingValue.getValueRange();
//        for (Long i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
//            for (String each : tableNames) {
//                if (each.endsWith(i % 2 + "")) {
//                    result.add(each);
//                }
//            }
//        }
//        return result;
//    }
