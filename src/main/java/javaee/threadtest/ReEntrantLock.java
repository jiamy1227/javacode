package javaee.threadtest;

import jdk.nashorn.internal.ir.Block;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLock {
    private static final Lock lock = new ReentrantLock();
    private static int count = 0;


    public static void main(String[] args) throws InterruptedException {
        lock.tryLock(1, TimeUnit.SECONDS);
        try {
            count += 1;
        }finally {
            lock.unlock();
        }

        System.out.println(count);
    }
}
