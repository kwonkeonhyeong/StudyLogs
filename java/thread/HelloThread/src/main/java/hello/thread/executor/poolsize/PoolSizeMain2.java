package hello.thread.executor.poolsize;

import static hello.thread.executor.ExecutorUtils.printState;
import static hello.util.MyLogger.log;
import static hello.util.MySleep.sleep;

import hello.thread.executor.RunnableTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolSizeMain2 {
    public static void main(String[] args) {
//        ExecutorService es = Executors.newFixedThreadPool(2);
        // ExecutorService es = new ThreadPoolExecutor(2, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(Runnable));
         ExecutorService es = new ThreadPoolExecutor(
                 0,
                 Integer.MAX_VALUE,
                 3,
                 TimeUnit.SECONDS,
                 new SynchronousQueue<Runnable>()
         );

        log("pool 생성)");
        printState(es);

        for (int i = 1; i <= 6; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es, taskName);
        }

        sleep(3000);
        log("== 작업 수행 완료 ==");
        printState(es);

        sleep(3000);
        log("== maximumPoolSize 대기 시간 초과 ==");
        printState(es);

        es.close();
        log("== shutdown 완료 ==");
    }
}
