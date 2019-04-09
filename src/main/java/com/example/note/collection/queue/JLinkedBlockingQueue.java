package com.example.note.collection.queue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class JLinkedBlockingQueue {

    Node currentNode;
    Node lastNode;
    ReentrantLock lock = new ReentrantLock();
    Condition isEmpty = lock.newCondition();


    static class Node {
        public Object obj;
        public Node next;
    }

    JLinkedBlockingQueue() {
        currentNode = new Node();
        lastNode = currentNode;
    }


    public void put(Object object) {

        lastNode.obj = object;
        lastNode.next = new Node();
        lastNode = lastNode.next;
    }

    public Object take() {
        Object obj = currentNode.obj;
        currentNode = currentNode.next;
        return obj;
    }




}
