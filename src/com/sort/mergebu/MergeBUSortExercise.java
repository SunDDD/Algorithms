package com.sort.mergebu;

import com.sort.merge.MergeSort;

/**
 * @author Carlos
 * @description
 * @Date 2019/7/17
 */

public class MergeBUSortExercise {

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {

        int N = a.length;

        aux = new Comparable[N];

        for (int sz = 1; sz < N; sz += sz) {
            for (int lo = 0; lo < N - sz; lo = lo + sz + sz) {
                MergeSort.merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }


    }


}
