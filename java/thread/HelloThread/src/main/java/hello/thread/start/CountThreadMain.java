package hello.thread.start;

import static hello.util.MyLogger.log;

public class CountThreadMain {
    public static void main(String[] args) {
        CountThread countThread = new CountThread();
        countThread.start();
    }

    static class CountThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    log("value = " + (i+1));
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
