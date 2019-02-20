package com.example.note.collection.map;


/**
 * Created by JIAZ on 2019/2/18.
 */
public class JHashMap<K, V> implements JMap {
    private final int DEFAULT_CAPACITY = 16;
    private final double LOAD_FACTER = 0.75;
    private int size = 0;
    Node[] table = new Node[DEFAULT_CAPACITY];

    public Object put(K key, V value) {
        int hash = key.hashCode();
        //计算当前hash存放数组位置
        int i = indexOf(hash, table.length);
        for (Node node = table[i]; node != null; node = node.next) {
            if (node.hash == hash && (node.key == key || key.equals(node.key))) {
                Object oldValue = node.value;
                node.value = value;
                return oldValue;
            }
        }
        //往数组添加元素
        addEntity(hash, key, value, i);
        return null;
    }


    public int indexOf(int hash, int length) {
        return hash % length;
    }

    public void addEntity(int hash, K key, V value, int i) {
        if (size > (DEFAULT_CAPACITY / LOAD_FACTER) && null != table[i]) {
            //扩容
        }
        //创建元素
        createEntity(hash, key, value, i);
    }

    public void createEntity(int hash, K key, V value, int i) {
        Node<K, V> node = table[i];
        table[i] = new Node<>(hash, key, value, node);
        size++;
    }


    static class Node<K, V> {
        int hash;
        K key;
        V value;
        Node next;
        Node(int hash, K key, V value, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}
