package com.sort.selection;

import com.sort.example.SortExample;

/**
 * @author Carlos
 * @description 选择排序
 * @Date 2019/7/12
 */

public class SelectionSort extends SortExample {

    public static void sort(Comparable[] a) {

        int N = a.length;

        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, min, i);
        }

    }

    public static void main(String[] args) {

        Integer[] a = getData(100);

        sort(a);
    }

}
