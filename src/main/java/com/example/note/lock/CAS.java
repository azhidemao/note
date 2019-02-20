package com.example.note.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by JIAZ on 2019/2/20.
 * idea:先进行计算，如果期望值与内存值相同，则进行操作，否则不变
 * warning：不能避免ABA问题
 */
public class CAS {
    private volatile int memoryValue;

    CAS(int memoryValue) {
        this.memoryValue = memoryValue;
    }

    public int lock(int inputValue) {
        while (true) {
            //先做操作得到结果
            int currentValue = memoryValue;
            int nextValue = currentValue + inputValue;
            //判断期望值与内存值相同
            if (judge(currentValue, nextValue)) {
                return nextValue;
            }
        }
    }

    public synchronized boolean judge(int expectValue, int nextValue) {
        return expectValue == deal(expectValue, nextValue);
    }

    public synchronized int deal(int expectValue, int nextValue) {
        int oldValue = memoryValue;
        //如果相同更新内存的值
        if (oldValue == expectValue) {
            memoryValue = nextValue;
        }
        //否则不进行改变
        return oldValue;
    }

    public static void main(String[] args) {
        CAS cas = new CAS(1);
        System.out.println(cas.lock(4));
    }

    private volatile int memoryValue2;

    public synchronized int incrementAndGet() {
        return ++memoryValue2;
    }

    private AtomicInteger memoryValue3 = new AtomicInteger();

    public int incrementAndGet2() {
        return memoryValue3.incrementAndGet();
    }

}
