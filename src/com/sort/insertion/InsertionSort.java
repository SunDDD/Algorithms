package com.sort.insertion;

import com.sort.example.SortExample;

/**
 * @author Carlos
 * @description 插入排序
 * @Date 2019/7/12
 */

public class InsertionSort extends SortExample {

    public static void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) {
            for (int j = i; j >= 1 && less(a[j], a[j-1]); j--){
                exch(a, j, j - 1);
            }
        }
    }

}
