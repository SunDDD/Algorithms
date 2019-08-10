package com.heap;

/**
 * @author Carlos
 * @description 二叉堆
 * @Date 2019/7/14
 */

public class Heap<Key extends Comparable<Key>> {

    private Key[] keys;
    private int N = 0;

    public Heap() {
        keys = (Key[])new Comparable[9];
    }

    public Heap(int maxN) {
        keys = (Key[])new Comparable[maxN + 1];
    }

    private boolean less(int i, int j) {
        return keys[i].compareTo(keys[j]) < 0;
    }

    public int size() {
         return this.N;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    private void exch(int i, int j) {
        Key t = keys[i];
        keys[i] = keys[j];
        keys[j] = t;
    }

    public void swim(int k) {
        while(k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k / 2;
        }
    }

    public void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j,j + 1)) {
                 j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    public void insert(Key v) {
        keys[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = keys[1];
        exch(1, N--);
        keys[N + 1] = null;
        sink(1);
        return max;
    }

    public static void main(String[] args) {
        Heap heap = new Heap(100);

        for (int i = 0; i < 8; i++) {
            heap.insert(i);
        }

        while (!heap.isEmpty()) {
            System.out.println(heap.delMax());
        }
    }


}
