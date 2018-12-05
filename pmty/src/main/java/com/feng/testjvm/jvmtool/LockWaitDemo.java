package com.feng.testjvm.jvmtool;

/**
 * 死锁等待演示
 * @author: PMTY
 * @create: 2018-12-04 10:59
 **/
public class LockWaitDemo implements Runnable {
    int a, b;
    public LockWaitDemo(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void run() {
        synchronized (Integer.valueOf(a)) {
            synchronized (Integer.valueOf(b)) {
                System.out.println(a + b);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new LockWaitDemo(1,2)).start();
            new Thread(new LockWaitDemo(2,1)).start();
        }
    }
}