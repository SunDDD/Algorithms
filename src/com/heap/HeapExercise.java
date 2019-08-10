package com.heap;

/**
 * @author Carlos
 * @description
 * @Date 2019/7/17
 */

public class HeapExercise<Key extends Comparable<Key>> {

    private Key[] keys;
    private int N = 0;

    public HeapExercise(int maxN) {
        this.keys = (Key[])new Comparable[maxN + 1];
    }

    public void exch(int i, int j) {
        Key key = keys[i];
        keys[i] = keys[j];
        keys[j] = key;
    }

    public boolean less(int i, int j) {
        return keys[i].compareTo(keys[j]) < 0;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int size() {
        return this.N;
    }

    public void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    public void sink(int k) {
        while (k * 2 < N) {
            int j = k * 2;

            if (j < N && less(j, j + 1)) {
                j++;
            }

            if (less(k, j)) {
                exch(k, j);
                k = j;
            } else {
                break;
            }
        }
    }

    public void insert(Key key) {
        keys[++N] = key;
        swim(N);
    }

    public Key delMax() {
        Key value = keys[1];
        exch(1, N--);
        keys[N + 1] = null;
        sink(1);
        return value;
    }

    public static void main(String[] args) {
        HeapExercise hp = new HeapExercise(100);

        for (int i = 0; i < 8; i++) {
            hp.insert(i);
        }

        while (!hp.isEmpty()) {
            System.out.println(hp.delMax());
        }
    }
}
