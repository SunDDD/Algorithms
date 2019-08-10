package com.search.frequency;

import com.search.bst.BST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author Carlos
 * @description 标准输入中单词出现的次数
 * @Date 2019/8/9
 */

public class FrequencyCounter {

    public static void main(String[] args) {

        int minlen = Integer.parseInt(args[0]);
        //1.标准
//        ST<String, Integer> st = new ST<>();

        //2.顺序链表
//        SequentialSearchST<String, Integer> st = new SequentialSearchST();

        BST<String ,Integer> st = new BST<>();

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.length() < minlen) {
                continue;
            }

            if (!st.contains(word)) {
                st.put(word, 1);
            } else {
                st.put(word, st.get(word) + 1);
            }
        }

        String max = " ";
        st.put(max, 0);

        for(String s : st.keys()) {
            if (st.get(s) > st.get(max)) {
                max = s;
            }
        }

        StdOut.println(max + " " + st.get(max));

        StdOut.println("yourself" + " " + st.get("yourself"));
    }

}
