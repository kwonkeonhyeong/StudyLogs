package hello;

import hello.thread.start.HelloThread;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread();
        helloThread.start();

        String name = helloThread.getName();
        System.out.println(name);
    }
}
