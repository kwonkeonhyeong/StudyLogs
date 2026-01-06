package hello.thread.start;

import static hello.util.MyLogger.log;
import static java.lang.Thread.sleep;

public class CountThreadMain2 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
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
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
