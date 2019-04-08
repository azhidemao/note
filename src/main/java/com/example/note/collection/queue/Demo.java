package com.example.note.collection.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo {
    public void demo(){
        ExecutorService exeutor = new ThreadPoolExecutor(2,4,60L, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());

    }
}
