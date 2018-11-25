package com.feng.testjvm.testgc;

/**
 * 测试引用计数算法的缺陷
 * @author: PMTY
 * @create: 2018-08-01 16:07
 **/
public class ReferenceCountingGC {

    public Object instance = null;
    private static final int count = 1024 * 1024;
    private byte[] bigSize = new byte[2 * count];

    public static void main(String[] args) {
        ReferenceCountingGC gcA = new ReferenceCountingGC();
        ReferenceCountingGC gcB = new ReferenceCountingGC();
        gcA.instance = gcB;
        gcB.instance = gcA;
        gcA = null;
        gcB = null;
        System.gc();
    }
}