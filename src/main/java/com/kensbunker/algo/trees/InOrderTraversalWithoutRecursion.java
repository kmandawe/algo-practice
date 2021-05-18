package com.kensbunker.algo.trees;

import java.util.*;

public class InOrderTraversalWithoutRecursion {

    public List<Integer> inorderTraversal(TreeNode<Integer> root) {
        List<Integer> finalList = new ArrayList<>();
        Stack<TreeNode<Integer>> helperStack = new Stack<>();
        if (root == null) {
            return finalList;
        }

        TreeNode<Integer> current = root;
        while (!helperStack.isEmpty() || current != null) {
            while (current != null) {
                helperStack.push(current);
                current = current.left;
            }

            current = helperStack.pop();
            finalList.add(current.val);

            current = current.right;
        }
        return finalList;
    }

    public static void main(String[] args) {
        MinHeightBstFromSortedArray bt = new MinHeightBstFromSortedArray();
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        TreeNode<Integer> root = bt.buildDriver(input);

        InOrderTraversalWithoutRecursion opt = new InOrderTraversalWithoutRecursion();
        System.out.println(opt.inorderTraversal(root));


    }
}
