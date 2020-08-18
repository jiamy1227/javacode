package javaee.threadtest.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(new MyThread("线程1"));
        executor.submit(new MyThread("线程2"));
        executor.submit(new MyThread("线程3"));
        executor.submit(new MyThread("线程4"));
        executor.submit(new MyThread("线程5"));
        executor.shutdown();
    }

}
class MyThread extends Thread{
    private String name;
    public MyThread(String name){
        this.name=  name;
    }
    @Override
    public void run() {
        try {
            System.out.println(name+"开始");
            Thread.sleep(1000);
            System.out.println(name+"结束");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
