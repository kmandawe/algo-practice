package com.kensbunker.algo.trees;

import java.util.LinkedList;
import java.util.Queue;

public class ValidBinarySearchTreeBFS {

    public boolean isValidBst(TreeNode node) {
        if (node == null) {
            return true;
        }
        Queue<AugmentedNode> queue = new LinkedList<>();
        queue.add(new AugmentedNode(node, Integer.MIN_VALUE, Integer.MAX_VALUE));

        while (!queue.isEmpty()) {
            AugmentedNode augmentedNode = queue.poll();
            TreeNode<Integer> currentNode = augmentedNode.node;
            if (currentNode.val < augmentedNode.min || currentNode.val > augmentedNode.max) {
                return false;
            }
            TreeNode left = currentNode.left;
            TreeNode right = currentNode.right;
            if (left != null) {
                queue.add(new AugmentedNode(left, augmentedNode.min, currentNode.val));
            }
            if (right != null) {
                queue.add(new AugmentedNode(right, currentNode.val, augmentedNode.max));
            }
        }
        return true;
    }

    private class AugmentedNode {
        TreeNode node;
        int min;
        int max;

        AugmentedNode(TreeNode node, int min, int max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node2.left = node1;
        node2.right = node4;

        node4.left = node3;
        node4.right = node5;

        ValidBinarySearchTreeBFS s = new ValidBinarySearchTreeBFS();
        System.out.println(s.isValidBst(node2));

    }
}
