package com.search.test;

import com.search.hash.SeparateChainingHashST;

/**
 * @author Carlos
 * @description 测试红黑树
 * @Date 2019/8/9
 */

public class TestRBBST {

    public static void main(String[] args) {

//        RedBlackBST<String, Integer> st= new RedBlackBST<>();

//        RedBlackBST<String ,Integer> st = new RedBlackBST<>();

        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>();

        String str = "S E A R C H X M P L S R";

        String s[] = str.split(" ");

        for (String key : s) {
            if (!st.contains(key)) {
                st.put(key, 1);
            } else {
                st.put(key, st.get(key) + 1);
            }
        }

        System.out.println(st.get("S") + " " + st.get("X") + " " + st.get("R"));

    }

}
