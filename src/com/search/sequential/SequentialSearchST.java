package com.search.sequential;

import java.util.Iterator;

/**
 * @author Carlos
 * @description 顺序查找（基于无序链表）
 * @Date 2019/8/9
 */

public class SequentialSearchST<Key extends Comparable<Key>, Value> implements Iterable<Key>{

    private Node head;
    private int size = 0;

    @Override
    public Iterator<Key> iterator() {
        return new RAIterator();
    }

    private class RAIterator implements Iterator<Key>{

        private Node x = head;

        @Override
        public boolean hasNext() {
            return x.next != null;
        }

        @Override
        public Key next() {
            x = x.next;
            return x.key;
        }

        @Override
        public void remove() {

        }

    }

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key) {

        for (Node x = head; x != null; x = x.next) {
            if (x.key.compareTo(key) == 0) {
                return x.value;
            }
        }

        return null;

    }

    public void put(Key key, Value value) {

        for (Node x = head; x != null; x = x.next) {
            if (x.key.compareTo(key) == 0) {
                x.value = value;
                return;
            }
        }

        this.head = new Node(key, value, this.head);
        size++;

    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {

    }

}
