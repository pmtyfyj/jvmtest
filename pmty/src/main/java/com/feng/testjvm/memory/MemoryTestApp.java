package com.feng.testjvm.memory;

import org.junit.Test;

/**
 * @author: PMTY
 * @create: 2018-11-30 15:40
 **/
public class MemoryTestApp {

    private static final int _1MB = 1024 * 1024;

    /**
     * -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
     */
    @Test
    public void testEdenMinorGC() {
        byte[] app1, app2, app3, app4;
        app1 = new byte[2 * _1MB];
        app2 = new byte[2 * _1MB];
        app3 = new byte[2 * _1MB];
        app4 = new byte[2 * _1MB]; //此时会出现一次 minor GC
    }
}