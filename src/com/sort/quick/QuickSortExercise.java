package com.sort.quick;

import com.sort.example.SortExampleExercise;
import com.sort.insertion.InsertionSortExercise;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Carlos
 * @description
 * @Date 2019/7/17
 */

public class QuickSortExercise extends SortExampleExercise {

    public static void sort(Comparable[] a) {

        StdRandom.shuffle(a);

        sort(a, 0, a.length - 1);

    }

    public static void sort(Comparable[] a, int lo, int hi) {

        if (hi < lo + 10) {
            InsertionSortExercise.sort(a);
            return;
        }

        int p = par(a, lo, hi);

        sort(a, lo, p - 1);
        sort(a, p + 1, hi);

    }

    public static int par(Comparable[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;

        Comparable v = a[lo];

        while (true) {

            while (less(a[++i], v)) {
                if (i >= hi) {
                    break;
                }
            }

            while (less(v, a[--j])) {
                if (j <= lo) {
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
