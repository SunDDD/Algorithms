package com.sort.merge;

import com.sort.example.SortExample;

/**
 * @author Carlos
 * @description 归并排序
 * @Date 2019/7/12
 */

public class MergeSort extends SortExample {

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {

        aux = new Comparable[a.length];

        sort(a, aux, 0, a.length - 1);
    }

    public static void sort(Comparable[]a ,Comparable[] aux, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;

        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
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
            } else if (less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }

    }



}
