package com.search.binary;

/**
 * @author Carlos
 * @description 二分查找（基于有序数组）
 * @Date 2019/8/9
 */

public class BinarySearchST <Key extends Comparable<Key>, Value>{

    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[])new Comparable[capacity];
        values = (Value[])new Object[capacity];
    }

    public int size() {
        return this.N;
    }

    public int rank(Key key) {

        int lo = 0;
        int hi = N - 1;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);

            if (cmp > 0) {
                lo = mid + 1;
            } else if (cmp < 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public Value get(Key key) {

        int i = rank(key);

        if (i < N && keys[i].compareTo(key) == 0) {
            return values[i];
        } else {
             return null;
        }
    }

    public void put(Key key, Value value) {

        int i = rank(key);

        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }

        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        N++;

    }

}
