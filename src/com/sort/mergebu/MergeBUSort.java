package com.sort.mergebu;

import com.sort.example.SortExample;
import com.sort.merge.MergeSort;
import edu.princeton.cs.algs4.StdDraw;

/**
 * @author Carlos
 * @description 自底向上的归并排序
 * @Date 2019/7/13
 */

public class MergeBUSort extends SortExample {
    private static Comparable[] aux;

/*    public static void merge(Comparable[] a, int lo, int mid, int hi) {
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
    }*/

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];

        for (int sz = 1; sz < N; sz += sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                MergeSort.merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
            draw(a);
            StdDraw.pause(10000);
            if (!isSorted(a)) {
                StdDraw.clear();
            }
        }


    }

    public static void main(String[] args) {
        Integer[] a = getData(100);

        sort(a);
    }
}
