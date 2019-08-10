package com.search.red;

/**
 * @author Carlos
 * @description 红黑树
 * @Date 2019/8/9
 */

public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {

        private Key key;
        private Value value;
        private Node left, right;
        private int N;
        private boolean color;

        Node (Key key, Value value, int N, boolean color) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }

    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    private Node rotateLeft(Node h) {

        Node x = h.right;
        h.right = x.left;
        h.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    private Node rotateRight(Node h) {

        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;

    }

    private void flipColors(Node x) {
        x.color = RED;
        x.left.color = BLACK;
        x.right.color = BLACK;
    }

    public void put(Key key, Value value) {
        this.root = put(this.root, key, value);
        this.root.color = BLACK;
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value, 1, RED);
        }

        int cmp = key.compareTo(x.key);

        if (cmp < 0) {
            x.left = put(x.left, key, value);
        }else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }

        if (isRed(x.right) && isRed(x.left)) {
            x = rotateLeft(x);
        }

        if (isRed(x.left) && isRed(x.left.left)) {
            x = rotateRight(x);
        }

        if (isRed(x.left) && isRed(x.right)) {
            flipColors(x);
        }

        x.N = size(x.left) + size(x.right) + 1;

        return x;
    }

    public Value get(Key key) {
        return get(this.root, key);
    }

    private Value get(Node x, Key key) {

        while (x != null) {

            int cmp = key.compareTo(x.key);

            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.value;
            }
        }
        return null;
    }

    public int size() {
        return size(this.root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }else {
            return x.N;
        }
    }

    public boolean contains(Key key) {
        return contains(this.root, key);
    }

    private boolean contains(Node x, Key key) {
        if (x == null) {
            return false;
        }

        int cmp = key.compareTo(x.key);

        if (cmp > 0) {
            return contains(x.right, key);
        } else if (cmp < 0) {
            return contains(x.left, key);
        } else {
            return true;
        }
    }

}
