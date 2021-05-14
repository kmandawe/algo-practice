package com.kensbunker.algo;

import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

public class BalancedTreeSolution {
    public boolean isBalanced(TreeNode root) {
        return checkIfBalanced(root).isBalanced();
    }

    private BalanceStatus checkIfBalanced(TreeNode root) {
        if (root == null) {
            return new BalanceStatus(true, -1, -1);
        }

        BalanceStatus leftStatus = checkIfBalanced(root.getChildAt(0));
        if (!leftStatus.isBalanced()) {
            return leftStatus;
        }

        BalanceStatus rightStatus = checkIfBalanced(root.getChildAt(1));
        if (!rightStatus.isBalanced()) {
            return rightStatus;
        }

        int leftHeight = Math.max(leftStatus.leftHeight, leftStatus.rightHeight) + 1;
        int rightHeight = Math.max(rightStatus.leftHeight, rightStatus.rightHeight) + 1;
        boolean balanced = Math.abs(leftHeight - rightHeight) <= 1;
        return new BalanceStatus(balanced, leftHeight, rightHeight);

    }


    public static void main(String[] args) {
        MyNode node1 = new MyNode(1);
        MyNode node2 = new MyNode(2);
        MyNode node3 = new MyNode(3);
        MyNode node4 = new MyNode(4);
        MyNode node5 = new MyNode(5);
        MyNode node6 = new MyNode(6);

        node1.setChildren(Arrays.asList(node2, node3));
        node2.setParent(node1);
        node3.setParent(node1);

        node3.setChildren(Arrays.asList(node4, node5));
        node4.setParent(node3);
        node5.setParent(node3);

        node5.setChildren(Arrays.asList(node6));
        node6.setParent(node5);

        BalancedTreeSolution s = new BalancedTreeSolution();
        System.out.println(s.isBalanced(node1));
    }

    private class BalanceStatus {

        private final boolean balanced;
        private final int leftHeight;
        private final int rightHeight;

        BalanceStatus(boolean balanced, int leftHeight, int rightHeight) {
            this.balanced = balanced;
            this.leftHeight = leftHeight;
            this.rightHeight = rightHeight;
        }

        public boolean isBalanced() {
            return balanced;
        }

    }
}



