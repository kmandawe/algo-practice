package com.kensbunker.algo;

import javax.swing.tree.TreeNode;
import java.util.Enumeration;
import java.util.List;

class MyNode implements TreeNode {

    private List<MyNode> children;
    private MyNode parent;
    private final int value;

    MyNode(int value) {
        this.value = value;
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        if (children == null || childIndex > children.size() - 1) {
            return null;
        }
        return children.get(childIndex);
    }

    @Override
    public int getChildCount() {
        return children.size();
    }

    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public int getIndex(TreeNode node) {
        return 0;
    }

    @Override
    public boolean getAllowsChildren() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public Enumeration children() {
        return null;
    }

    public List<MyNode> getChildren() {
        return children;
    }

    public void setChildren(List<MyNode> children) {
        this.children = children;
    }

    public void setParent(MyNode parent) {
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }
}
