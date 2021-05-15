package com.kensbunker.algo;

public class BalancedTreeSolution {
    public boolean isBalanced(TreeNode root) {
        return checkIfBalanced(root).isBalanced();
    }

    private BalanceStatus checkIfBalanced(TreeNode root) {
        if (root == null) {
            return new BalanceStatus(true, -1, -1);
        }

        BalanceStatus leftStatus = checkIfBalanced(root.left);
        if (!leftStatus.isBalanced()) {
            return leftStatus;
        }

        BalanceStatus rightStatus = checkIfBalanced(root.right);
        if (!rightStatus.isBalanced()) {
            return rightStatus;
        }

        int leftHeight = Math.max(leftStatus.leftHeight, leftStatus.rightHeight) + 1;
        int rightHeight = Math.max(rightStatus.leftHeight, rightStatus.rightHeight) + 1;
        boolean balanced = Math.abs(leftHeight - rightHeight) <= 1;
        return new BalanceStatus(balanced, leftHeight, rightHeight);

    }


    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);


        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        node5.left = node6;

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



