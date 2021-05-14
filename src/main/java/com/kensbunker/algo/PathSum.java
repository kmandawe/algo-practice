package com.kensbunker.algo;

import javax.swing.tree.TreeNode;
import java.util.Arrays;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        boolean isLeaf = root.getChildAt(0) == null && root.getChildAt(1) == null;
        if (isLeaf && targetSum - ((MyNode) root).getValue() == 0) {
            return true;
        }
        return hasPathSum(root.getChildAt(0), targetSum - ((MyNode) root).getValue()) ||
                hasPathSum(root.getChildAt(1), targetSum - ((MyNode) root).getValue());
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

        node1.setChildren(Arrays.asList(null, node2));
        node2.setParent(node1);

        node2.setChildren(Arrays.asList(node2_2, node5));

        PathSum s = new PathSum();
        System.out.println(s.hasPathSum(node1, 5));
    }
}
