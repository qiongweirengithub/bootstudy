package app;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * @author qunar-qw
 * @date 18-7-12
 */
public class PriorityTransferQueue extends PriorityBlockingQueue implements TransferQueue {

    @Override public boolean tryTransfer(Object o) {
        return false;
    }

    @Override public void transfer(Object o) throws InterruptedException {

    }

    @Override public boolean tryTransfer(Object o, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override public boolean hasWaitingConsumer() {
        return false;
    }

    @Override public int getWaitingConsumerCount() {
        return 0;
    }
}