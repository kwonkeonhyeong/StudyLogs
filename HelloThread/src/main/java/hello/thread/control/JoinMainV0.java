package hello.thread.control;

import static hello.util.MyLogger.log;
import static hello.util.MySleep.*;

import hello.util.MySleep;

public class JoinMainV0 {
    public static void main(String[] args) {
        log("start");
        Job1 job = new Job1();
        Thread thread1 = new Thread(job);
        Thread thread2 = new Thread(job);

        thread1.start();
        thread2.start();
        log("End");
    }

     static class Job1 implements Runnable {
        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);
            log("작업 완료");
        }
     }

     static class Job2 implements Runnable {
        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);
            log("작업 완료");
        }
     }
}
