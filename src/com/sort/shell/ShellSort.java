package com.sort.shell;

import com.sort.example.SortExample;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Carlos
 * @description 希尔排序
 * for (int j = i; j >= h && less(a[j], a[j - h]); j-=h)
 * @Date 2019/7/12
 */

public class ShellSort extends SortExample {

    public static void sort(Comparable[] a) {

        int N = a.length;
        int h = 1;

        while (h < N/3) {
            h = 3 * h + 1;
        }

        System.out.println(h);

        while (h >= 1) {

            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }

            draw(a);
            StdDraw.pause(2000);
            if (h > 1) {
                StdDraw.clear();
            }
            h = h/3;

        }

    }

    public static void main(String[] args) {
        int N = 100;
        Integer[] a = new Integer[N];

        for (int i = 0; i < N; i++) {
            a[i] = i;
        }

        StdRandom.shuffle(a);

        draw(a);
        StdDraw.pause(500);
        StdDraw.clear();

        sort(a);

    }

}
