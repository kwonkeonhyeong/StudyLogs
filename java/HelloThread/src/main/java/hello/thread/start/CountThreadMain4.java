package hello.thread.start;

import static hello.util.MyLogger.log;
import static java.lang.Thread.sleep;

public class CountThreadMain4 {
    public static void main(String[] args) {
        Thread threadA = new Thread(new ThreadA());
        Thread threadB = new Thread(new ThreadB());

        threadA.start();
        threadB.start();

    }

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("A");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("B");
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
