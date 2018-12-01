package com.feng.testjvm.memory;

/**
 * @author: PMTY
 * @create: 2018-11-30 15:40
 **/
public class MemoryTestApp {

    private static final int _1MB = 1024 * 1024;

    /**
     * 对象优先在Eden分配
     * -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
     */
    public static void testEdenMinorGC() {
        byte[] app1, app2, app3, app4;
        app1 = new byte[2 * _1MB];
        app2 = new byte[2 * _1MB];
        app3 = new byte[2 * _1MB];
        app4 = new byte[4 * _1MB]; //此时会出现一次 minor GC
    }

    /**
     * 大对象直接进入老年代
     * -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc -XX:PretenureSizeThreshold=3145728 (3MB)
     */
    public static void testPretenureSizeThreshold() {
        byte[] app;
        app = new byte[4 * _1MB];  //直接分配老年代中
    }

    /**
     * 长期存活的对象将进入老年代
     * -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc -XX:MaxTenuringThreshold=15 -XX:TargetSurvivorRatio=90 -XX:+PrintTenuringDistribution
     */
    public static void testTenuringThreshold() {
        byte[] app1, app2, app3;
        app1 = new byte[_1MB / 4];
        // 什么时候进入老年代取决于-XX:MaxTenuringThreshold设置
        app2 = new byte[4 * _1MB];
        app3 = new byte[4 * _1MB];
        app3 = null;
        app3 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
//        testEdenMinorGC();
//        testPretenureSizeThreshold();
        testTenuringThreshold();
    }
}