package com.feng.testjvm.jvmtool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BTrace跟踪演示
 * @author: PMTY
 * @create: 2018-12-04 12:04
 **/
public class BTraceDemo {
    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws IOException {
        BTraceDemo traceDemo = new BTraceDemo();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            bufferedReader.readLine();
            int a = (int) Math.round(Math.random() * 1000);
            int b = (int) Math.round(Math.random() * 1000);
            System.out.println(add(a, b));
        }
    }
}