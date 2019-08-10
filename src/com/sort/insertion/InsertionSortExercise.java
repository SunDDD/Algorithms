package com.sort.insertion;

import com.sort.example.SortExampleExercise;

/**
 * @author Carlos
 * @description
 * @Date 2019/7/17
 */

public class InsertionSortExercise extends SortExampleExercise {

    public static void sort(Comparable[] a) {

        for (int i = 1; i < a.length; i++) {

            for (int j = i; j >= 1; j--) {

                if (less(a[j - 1], a[j])) {
                    break;
                }

                exch(a, j , j - 1);

            }

        }

    }
}
