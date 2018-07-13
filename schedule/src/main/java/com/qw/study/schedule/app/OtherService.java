package com.qw.study.schedule.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author qunar-qw
 * @date 18-7-11
 */
@Service
public class OtherService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OtherService.class);



    public static void main(String[] args) {

        for (int count = 0; count < 10; count++) {

            try {
                new OtherService().exceptionGene(count);
                LOGGER.info("actioncode succ");
            } catch (Exception e) {
                if(count == 0 && new OtherService().check()) {
                    LOGGER.info("bind succ");
                    continue;
                }
                LOGGER.info("count:{}",count);
                throw e;
            }
            return;
        }

        return;
    }

    private void exceptionGene(int count) {
        if(count<2) {
            throw new RuntimeException();
        }
    }

    private boolean check() {
        return true;
    }

}