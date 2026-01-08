package hello.thread.start;

import static hello.util.MyLogger.log;
import static java.lang.Thread.sleep;

public class CountThreadMain3 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    log("value = " + (i+1));
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
    }
}
