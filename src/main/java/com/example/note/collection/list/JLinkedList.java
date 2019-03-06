package com.example.note.collection.list;

import java.util.LinkedList;

/**
 * Created by JIAZ on 2019/3/6.
 */
public class JLinkedList {
    Node node;
    transient Node first;
    transient Node last;
    transient int size = 0;
    transient int modCount = 0;

    public JLinkedList() {
        node = new Node();
    }

    public Node addSelf(Object a) {
        Node temp = node;
        Node pretemp = null;
        while (true) {
            if (temp == null) {
                temp = new Node();
            }
            if (temp.item == null) {
                temp.item = a;
                if (pretemp != null) {
                    temp.pre = pretemp;
                    pretemp.next = temp;
                }
                break;
            }
            pretemp = temp;
            temp = temp.next;
        }
        return node;
    }

    public Node addOffical(Object a) {
        return linkLast(a);
    }

    public Node linkLast(Object a) {
        Node l = last;
        Node newNode = new Node(a, l, null);
        if (l != null) {
            l.next = newNode;
        } else {
            first = newNode;
        }
        last = newNode;
        size++;
        return newNode;
    }



    static class Node<E> {
        private E item;
        private Node pre;
        private Node next;

        public Node(E item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }

        public Node() {
        }
    }

    public static void main(String[] args) {
        JLinkedList list = new JLinkedList();
        list.addOffical(1);
        list.addOffical(2);
        System.out.println(list);
        LinkedList list1 = new LinkedList();

    }
}
