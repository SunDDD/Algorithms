package com.sort.example;

import com.sort.quick.QuickSortExercise;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Carlos
 * @description
 * @Date 2019/7/17
 */

public class SortExampleExercise {

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {

        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;

    }

    public static void draw(Comparable[] a) {

        StdDraw.setXscale(-1, a.length + 1);

        Comparable max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (less(max, a[i])) {
                max = a[i];
            }
        }

        StdDraw.setYscale(-2, (Integer)max + 2);

        StdDraw.setPenColor(StdDraw.GRAY);

        for (int i = 0; i < a.length; i++) {

            int y = (Integer)a[i];

            StdDraw.filledRectangle(i + 0.5, y / 2.0, 0.3, y / 2.0);

        }

    }

    public static Integer[] getData(int N) {

        Integer[] integers = new Integer[N];

        for (int i = 0; i < N; i++) {
            integers[i] = i;
        }

        StdRandom.shuffle(integers);

        return integers;

    }

    public static boolean isSorted(Comparable[] a) {

        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {

        Integer[] a = getData(100);

        //1.绘图
        draw(a);
        StdDraw.pause(200);
        StdDraw.clear();

        //2.是否有序
        System.out.println(isSorted(a));

        //3.排序
        //3.1选择排序
//        SelectionSortExercise.sort(a);

        //3.2插入排序
//        InsertionSortExercise.sort(a);

        //3.3希尔排序
//        ShellSortExercise.sort(a);

        //3.4归并排序
//        MergeSortExercise.sort(a) ;

        //3.5快速排序
        QuickSortExercise.sort(a);

        //4.排序后绘图
        draw(a);

        //4.排序后查看是否有序
        System.out.println(isSorted(a));

    }

}
