package com.sort.heap;

import com.sort.example.SortExample;

/**
 * @author Carlos
 * @description 堆排序
 * @Date 2019/7/14
 */

public class HeapSort extends SortExample {

    public static void sort(Comparable[] a) {
        int N = a.length;

        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }

        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }

    }

    public static void sink(Comparable[] a, int k, int N) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && less(a, j, j + 1)) {
                j++;
            }
            if (!less(a, k, j)) {
                break;
            }
            exch(a, k, j);
            k = j;
        }
    }

    public static boolean less(Comparable[] a, int i, int j) {
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = t;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[10];
        a[4] = 5;
        a[5] = 6;
        System.out.println(less(a, 6, 5));
        exch(a, 5, 6);
        System.out.println(less(a, 6, 5));
    }

}
