package com.feng.testjvm.memory;

/**
 * volatile测试
 * @author: PMTY
 * @create: 2018-12-05 16:10
 **/
public class TestVolatile {

    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();
        while (true) {
            if (td.getFlag()) {
                System.out.println("主线程flag： " + td.getFlag());
                break;
            }
        }
    }
}

class ThreadDemo implements Runnable {

    private volatile boolean flag = false;

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void run() {
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("其他线程flag： " + flag);
    }
}