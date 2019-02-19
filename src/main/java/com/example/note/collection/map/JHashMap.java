package com.example.note.collection.map;


/**
 * Created by JIAZ on 2019/2/18.
 */
public class JHashMap<K, V> implements JMap {
    private final int DEFAULT_CAPACITY = 16;
    Node[] table = new Node[DEFAULT_CAPACITY];

    public Object put(K key, V value) {
        int hash = key.hashCode();
        int i = indexOf(hash, table.length);
        for (Node node = table[i]; node != null; node = node.next) {
            if (node.hash == hash && (node.key == key || key.equals(node.key))) {
                Object oldValue = node.value;
                node.value = value;
                return oldValue;
            }
        }

        return null;
    }

    public int indexOf(int hash, int length) {
        return hash % length;
    }

    public void addNode(int hash, K key, V value, int i) {
        new Node<>(hash, key, value, null);
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
