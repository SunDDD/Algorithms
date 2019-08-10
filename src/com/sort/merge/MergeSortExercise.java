package com.sort.merge;

import com.sort.example.SortExampleExercise;

/**
 * @author Carlos
 * @description
 * @Date 2019/7/17
 */

public class MergeSortExercise extends SortExampleExercise {

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {

        int N = a.length;

        aux = new Comparable[N];

        sort(a, aux, 0, N - 1);

    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {

        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;

        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);

    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {

            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }

    }

}
