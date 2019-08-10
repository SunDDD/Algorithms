package com.search.hash;

import edu.princeton.cs.algs4.SequentialSearchST;

/**
 * @author Carlos
 * @description 基于拉链法的散列表
 * @Date 2019/8/10
 */

public class SeparateChainingHashST<Key, Value> {

    private int N;   //键值对总数
    private int M;   //散列表的大小
    private SequentialSearchST<Key, Value>[] st;   //存放链表对象的数组

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        //创建M条链表
        this.M = M;
        st = (SequentialSearchST<Key, Value>[])new SequentialSearchST[M];

        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        st[hash(key)].put(key, value);
    }

    public boolean contains(Key key) {
        return st[hash(key)].contains(key);
    }

}
