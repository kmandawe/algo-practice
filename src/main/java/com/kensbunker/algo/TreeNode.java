package com.kensbunker.algo;

public class TreeNode<T> {
    T val;
    TreeNode<T> left;
    TreeNode<T> right;
    TreeNode<T> parent;

    TreeNode(T val) {
        this.val = val;
    }
}