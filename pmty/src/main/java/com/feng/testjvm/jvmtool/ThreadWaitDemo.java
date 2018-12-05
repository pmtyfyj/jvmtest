package com.feng.testjvm.jvmtool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 线程等待演示代码
 * @author: PMTY
 * @create: 2018-12-04 10:30
 **/
public class ThreadWaitDemo {

    /**
     * 线程死循环演示
     */
    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (true);
            }
        },"testBusyThread");
        thread.start();
    }

    /**
     * 线程等待演示
     * @param lock
     */
    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        Object o = new Object();
        createLockThread(o);
    }
}