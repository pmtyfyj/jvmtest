package com.feng.testjvm.finalize;

/**
 * GC时对象自我拯救
 * 一个对象的finalize()方法最多只会被系统自动调用一次
 * @author: PMTY
 * @create: 2018/08/04 13:08
 **/
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;
    public void isAlive() {
        System.out.println("对象还存活");
    }

    @Override
    protected  void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize 方法执行");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        //finalize方法优先级低，暂停0.5秒等待
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("对象被回收");
        }

        //对象自救失败
        SAVE_HOOK = null;
        System.gc();
        //finalize方法优先级低，暂停0.5秒等待
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("对象被回收");
        }
    }
}
