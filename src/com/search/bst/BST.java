package com.search.bst;

import edu.princeton.cs.algs4.Queue;

/**
 * @author Carlos
 * @description 基于二叉查找树的符号表
 * @Date 2019/8/9
 */

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {

        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    public int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.N;
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

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {

        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);

        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return x.value;
        }
    }

    public void put(Key key, Value value) {
        this.root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {

        if (x == null) {
            return new Node(key, value, 1);
        }

        int cmp = key.compareTo(x.key);

        if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else {
            x.value = value;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        return min(this.root).key;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }

        return min(x.left);
    }

    public Key max() {
        return max(this.root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }

        return max(x.right);
    }



    public Key floor(Key key) {
        Node x = floor(this.root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node floor(Node x, Key key) {

        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }

    public Key select(int k) {
        return select(this.root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }

        int t = size(x.left);

        if (k < t) {
            return select(x.left, k);
        } else if (k > t) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }

    public int rank(Key key) {
        return rank(this.root, key);
    }

    private int rank(Node x, Key key) {

        if (x == null) {
            return 0;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(x.left, key);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(x.right, key);
        } else {
            return size(x.left);
        }

    }

    public void deleteMin() {
        this.root = deleteMin(this.root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }

        x.left = deleteMin(x.left);

        x.N = size(x.left) + size(x.right) + 1;

        return x;
    }

    public void deleteMax() {
        this.root = deleteMax(this.root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) {
            return x.left;
        }

        x.right = deleteMax(x.right);

        x.N = size(x.left) + size(x.right) + 1;

        return x;
    }

    public void delete(Key key) {
        this.root = delete(this.root, key);
    }

    private Node delete(Node x, Key key) {

        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);

        if (cmp > 0) {
            return delete(x.right, key);
        } else if (cmp < 0) {
            return delete(x.left, key);
        } else {

            if (x.right == null) {
                return x.left;
            }

            if (x.left == null) {
                return x.right;
            }

            Node t = x;
            x = min(x.right);
            x.right = deleteMin(t.right);
            x.left = t.left;

        }

        x.N = size(x.left) + size(x.right) + 1;
        return x;

    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    private Iterable<Key> keys(Key lo, Key hi) {

        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;

    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {

        if (x == null) {
            return;
        }

        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) {
            keys(x.left, queue, lo, hi);
        }
        if (cmplo <= 0 && cmphi >= 0) {
            queue.enqueue(x.key);
        }
        if (cmphi > 0) {
            keys(x.right, queue, lo, hi);
        }

    }

}
