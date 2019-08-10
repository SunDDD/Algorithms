package com.sort.shell;

import com.sort.example.SortExampleExercise;

/**
 * @author Carlos
 * @description
 * @Date 2019/7/17
 */

public class ShellSortExercise extends SortExampleExercise {

    public static void sort(Comparable[] a) {

        int N = a.length;
        int h = 1;

        while (h < N / 3) {

            h = h * 3 + 1;

        }

        while (h > 0) {

            for (int i = h; i < N; i++) {

                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {

                    exch(a, j , j - h);

                }

            }

            h = (h - 1) / 3;

        }

    }
}
