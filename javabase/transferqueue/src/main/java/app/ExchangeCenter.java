package app;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * https://blog.csdn.net/coslay/article/details/45288567
 * http://ifeve.com/customizing-concurrency-classes-11-2/ 实现一个基于优先级的传输队列
 * https://www.cnblogs.com/junneyang/p/8267194.html  Springboot-Quartz-分布式任务调度
 *
 * @author qunar-qw
 * @date 18-7-12
 */
public class ExchangeCenter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeCenter.class);

    public static void main(String[] args) {

        LinkedTransferQueue<String> transferQueue = new LinkedTransferQueue<>();
        List<Runnable> producers = Lists.newArrayList();
        List<Runnable> consumers = Lists.newArrayList();

        producers.add(new Producer(transferQueue));
        consumers.add(new Consumer(transferQueue, "consumer1"));
        consumers.add(new Consumer(transferQueue, "consumer2"));
        consumers.add(new Consumer(transferQueue, "consumer3"));
        consumers.add(new Consumer(transferQueue, "consumer4"));


        for (Runnable producer:producers) {
            producer.run();
        }

        for (Runnable consumer:consumers) {
            consumer.run();
        }



    }

}

class Producer implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    private LinkedTransferQueue<String> transferQueue;

    ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);

    public Producer(LinkedTransferQueue<String> transferQueue) {
        this.transferQueue = transferQueue;
    }

    private void start() throws InterruptedException {
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override public void run() {
                try {
                    transferQueue.transfer("product");
                    LOGGER.info("producer running");
                } catch (InterruptedException e) {
                    LOGGER.error("producer run error");
                }
            }
        }, 0, 3000, TimeUnit.MILLISECONDS);

    }


    @Override public void run() {
        if(transferQueue != null) {
            try {
                start();
            } catch (InterruptedException e) {
                LOGGER.error("producer error", e);
            }
        }
    }
}

class Consumer implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    private LinkedTransferQueue<String> transferQueue;
    private String name = "";

    public Consumer(LinkedTransferQueue<String> transferQueue, String name) {
        this.transferQueue = transferQueue;
        this.name = name;
    }

    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);


    private void start() throws InterruptedException {
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override public void run() {
                try {
                    LOGGER.info("{}-消费获取到:{}",name, transferQueue.take());
                } catch (InterruptedException e) {
                    LOGGER.error("消费失败", e);
                }
            }
        }, 1,1, TimeUnit.SECONDS);
    }

    @Override public void run() {
        if(transferQueue != null) {
            try {
                start();
            } catch (InterruptedException e) {
                LOGGER.error("producer error", e);
            }
        }
    }
}

