package com.sort.quick;

import com.sort.example.SortExample;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Carlos
 * @description 快速排序
 * @Date 2019/7/14
 */

public class QuickSort extends SortExample {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);

        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {

        if (hi <= lo + 10) {
            Insertion.sort(a);
            return;
        }

        int j = p(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);

    }

    private static int p(Comparable[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;

        Comparable v = a[lo];

        while(true) {

            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }

            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            exch(a, i, j);

        }

        exch(a, lo, j);
        return j;


    }

}
