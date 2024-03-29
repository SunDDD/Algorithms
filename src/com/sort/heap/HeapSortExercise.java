package com.sort.heap;

import com.sort.example.SortExampleExercise;

/**
 * @author Carlos
 * @description
 * @Date 2019/7/17
 */

public class HeapSortExercise extends SortExampleExercise {
    public static void sort(Comparable[] a) {
        int N = a.length;

        for (int k = N/2; k >= 1; k--) {
            sink(a, k, N);
        }

        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private static void sink(Comparable[] a, int k, int N){
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(a, j, j + 1)) {
                j++;
            }
            if (less(a, j, k)){
                break;
            }

            exch(a, j, k);
            k = j;
        }
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = t;
    }
}