package hello.thread.bounded;

import static hello.util.MyLogger.log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BoundedQueueV6_4 implements BoundedQueue {

    private final BlockingQueue<String> queue;

    public BoundedQueueV6_4(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(String data) {
        queue.add(data);
    }

    @Override
    public String take() {
        return queue.remove();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
