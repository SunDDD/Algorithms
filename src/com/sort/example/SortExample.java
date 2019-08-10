package com.sort.example;

import com.sort.quick.QuickSort;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Carlos
 * @description 排序模板类
 * @Date 2019/7/12
 */

public class SortExample {

    public static void sort(Comparable[] a) {

    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;

    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean isSorted(Comparable[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void draw(Comparable[] a) {

        StdDraw.setXscale(-1, a.length + 1);

        Comparable max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (less(max, a[i])) {
                max = a[i];
            }
        }

        StdDraw.setYscale(-2, (Integer)max + 1);

        for (int i = 0; i < a.length; i++) {
            int y = (Integer)a[i];

            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.filledRectangle(i+0.5, y/2.0, 0.3, y/2.0);
        }

    }

    public static Integer[] getData(int N) {
        Integer[] a = new Integer[N];

        for (int i = 0; i < N; i++) {
            a[i] = i;
        }

        StdRandom.shuffle(a);

        return a;
    }

    public static void main(String[] args) {

        int N =100;
        Integer[] a = getData(N);

        System.out.println(isSorted(a));

        //选择排序
        //Selection.sort(a);

        //插入排序
        //Insertion.sort(a);

        //希尔排序
        //Shell.sort(a);

        //归并排序
        //MergeSort.sort(a);

        //自底向上的归并排序
        //MergeBUSort.sort(a);

        //快速排序
        QuickSort.sort(a);
        //draw(a);

        //堆排序
        //HeapSort.sort(a);
        draw(a);
        System.out.println(isSorted(a));

    }
}
