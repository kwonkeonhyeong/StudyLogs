package hello.thread.control;

import static hello.util.MyLogger.log;

public class ThreadStateMain {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable(), "myThread");
        log("myThread.state1 = " + thread.getState());
        log("myThread.start()");
        thread.start();
        try {
            Thread.sleep(1000);
            log("myThread.state3 = " + thread.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                log("start");
                log("thread.state2 = " + Thread.currentThread().getState());
                log("sleep() start");
                Thread.sleep(3000);
                log("sleep() end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


