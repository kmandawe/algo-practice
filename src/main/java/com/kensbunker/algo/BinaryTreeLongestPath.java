package com.kensbunker.algo;

public class BinaryTreeLongestPath {
    public int maxDiameter(TreeNode<Integer> root) {
        return maxTreeDiameter(root).bestDiameter;
    }

    private TreeDiameter maxTreeDiameter(TreeNode<Integer> node) {
        if (node == null) {
            return new TreeDiameter(0, 0);
        }
        TreeDiameter leftDiam = maxTreeDiameter(node.left);
        TreeDiameter rightDiam = maxTreeDiameter(node.right);
        int leftAndRightMax = Math.max(leftDiam.bestDiameter, rightDiam.bestDiameter);
        int bestDiameter = Math.max(leftAndRightMax, leftDiam.height + rightDiam.height);
        int treeHeight = Math.max(leftDiam.height, rightDiam.height);
        return new TreeDiameter(bestDiameter, treeHeight + 1);
    }

    private class TreeDiameter {
        int bestDiameter;
        int height;

        TreeDiameter(int bestDiameter, int height) {
            this.bestDiameter = bestDiameter;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        BinaryTreeLongestPath opt = new BinaryTreeLongestPath();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        System.out.println(opt.maxDiameter(node1));

        node1.left = node2;
        System.out.println(opt.maxDiameter(node1));

        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        node4.left = node6;

        node5.left = node7;
        node5.right = node8;

        node6.right = node9;

        System.out.println(opt.maxDiameter(node1));


    }
}
