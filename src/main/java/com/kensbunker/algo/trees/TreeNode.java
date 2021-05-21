package com.kensbunker.algo.trees;

public class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode<T> parent;

    public TreeNode(T val) {
        this.val = val;
    }
}