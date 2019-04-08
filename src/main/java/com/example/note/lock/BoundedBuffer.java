package com.example.note.lock;


import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
    ReentrantLock lock = new ReentrantLock();
    Condition isNull = lock.newCondition();
    Condition isEmpty = lock.newCondition();
    Object[] items;
    int putIndex ;
    int takeIndex ;

    BoundedBuffer(int capacity) {
        items = new Object[capacity];
        putIndex = 0;
        takeIndex = -1;
    }

    public void put(Object obj) {
        lock.lock();
        if (putIndex == items.length) {
            try {
                isNull.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        items[putIndex] = obj;
        putIndex++;
        items = Arrays.copyOf(items, putIndex + 1);
        isEmpty.signal();
    }

    public Object take() {
        Object obj = null;
        lock.lock();
        if (takeIndex < 0) {
            try {
                isEmpty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        obj = items[takeIndex];
        takeIndex--;
        isNull.signal();
        return obj;
    }


    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer(1);
        Thread thread = new Thread(()->{
            Object obj = buffer.take();
            System.out.println("take->" + obj);
        });
        thread.start();
        Thread thread2 = new Thread(()->{
            System.out.println(buffer.items.length);
            buffer.put(1);
            System.out.println(buffer.items.length);
        });
        thread2.start();



    }

}
