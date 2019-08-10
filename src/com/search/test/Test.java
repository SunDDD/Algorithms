package com.search.test;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author Carlos
 * @description 符号表测试用例
 * @Date 2019/8/9
 */

public class Test {

    public static void main(String[] args) {

        ST<String , Integer> st = new ST<>();

        String s = "SEARCHEXAMPLE";

        for (int i = 0; i < s.length(); i++) {

            String key = String.valueOf(s.charAt(i));

            st.put(key, i);

        }

        for (String str : st.keys()) {
            StdOut.println(str + " " + st.get(str));
        }

    }

}
