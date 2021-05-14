package com.kensbunker.algo;

import javax.swing.tree.TreeNode;
import java.util.Arrays;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode node) {
        if (node == null) {
            return true;
        }
        return symmetricChildren(node.getChildAt(0), node.getChildAt(1));
    }

    private boolean symmetricChildren(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return ((MyNode) left).getValue() == ((MyNode) right).getValue() &&
                    symmetricChildren(left.getChildAt(1), right.getChildAt(0)) &&
                    symmetricChildren(left.getChildAt(0), right.getChildAt(1));
        }
        return false;
    }

    public static void main(String[] args) {
        MyNode node1 = new MyNode(1);
        MyNode node1_2 = new MyNode(1);
        MyNode node2 = new MyNode(2);
        MyNode node2_2 = new MyNode(2);
        MyNode node2_3 = new MyNode(2);
        MyNode node2_4 = new MyNode(2);
        MyNode node3 = new MyNode(3);
        MyNode node4 = new MyNode(4);
        MyNode node5 = new MyNode(5);
        MyNode node6 = new MyNode(6);
        MyNode node7 = new MyNode(7);

        node4.setChildren(Arrays.asList(node2, node2_2));
        node2.setParent(node4);
        node2_2.setParent(node4);

        node2.setChildren(Arrays.asList(node1, node2_3));
        node1.setParent(node2);
        node2_3.setParent(node2);

        node2_2.setChildren(Arrays.asList(node2_4));
        node2_4.setParent(node2_2);

        SymmetricTree s = new SymmetricTree();
        System.out.println(s.isSymmetric(node2));
    }
}
