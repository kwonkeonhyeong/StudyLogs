package hello.thread.executor.reject;

import static hello.util.MyLogger.log;

import hello.thread.executor.RunnableTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

public class RejectMainV1 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new ThreadPoolExecutor.AbortPolicy());

        executor.submit(new RunnableTask("task1"));

        try {
            executor.submit(new RunnableTask("task2"));
        } catch (RejectedExecutionException e) {
            log("요청 초과");
            // 포기, 다시 시도 등 다양한 고민을 하면 됨
            log(e);
        }

        executor.close();
    }
}
