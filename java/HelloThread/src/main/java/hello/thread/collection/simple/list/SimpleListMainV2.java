package hello.thread.collection.simple.list;

import static hello.util.MyLogger.log;

public class SimpleListMainV2 {
    public static void main(String[] args) throws InterruptedException {
//        test(new BasicList());
//        test(new SyncList());

        BasicList basicList = new BasicList();
        SyncProxyList proxyList = new SyncProxyList(basicList);
        test(proxyList);
    }

    private static void test(SimpleList list) throws InterruptedException {
        log(list.getClass().getSimpleName());

        Runnable addA = new Runnable() {
            @Override
            public void run() {
                list.add("A");
                log("Thread-1: list.add(A)");
            }
        };

        Runnable addB = new Runnable() {
            @Override
            public void run() {
                list.add("B");
                log("Thread-2: list.add(B)");
            }
        };

        Thread t1 = new Thread(addA, "Thread-1");
        Thread t2 = new Thread(addB, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        log(list);
    }
}
