package com.feng.testjvm.jvmtool;

import java.util.ArrayList;

/**
 * JVM可视化工具测试
 * @author: PMTY
 * @create: 2018-12-04 09:24
 **/
public class JVMToolDemo {

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    /**
     * JConsole监视代码
     * -Xms100M -Xmx100M -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
     */
    public static void fillHeap(int num) throws InterruptedException {
        ArrayList<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            //稍作延时，令监视曲线更明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
//        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
        System.gc();
    }
}