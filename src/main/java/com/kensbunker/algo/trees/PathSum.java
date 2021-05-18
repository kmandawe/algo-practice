package com.kensbunker.algo.trees;

public class PathSum {
    public boolean hasPathSum(TreeNode<Integer> root, int targetSum) {
        if (root == null) {
            return false;
        }
        boolean isLeaf = root.left == null && root.right == null;
        if (isLeaf && targetSum - root.val == 0) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }


    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node_1 = new TreeNode(-1);
        TreeNode node5 = new TreeNode(5);
        TreeNode node5_2 = new TreeNode(5);

        node5.left = node5_2;

        node5_2.left = node1;
        node5_2.right = node_1;

        PathSum s = new PathSum();
        System.out.println(s.hasPathSum(node5, 10));
    }
}
