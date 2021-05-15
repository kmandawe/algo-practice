package com.kensbunker.algo;

import java.util.HashMap;
import java.util.Map;

public class LowestCommonAncestorParent {

    public TreeNode lcaParent(TreeNode<Integer> n1, TreeNode<Integer> n2) {
        Map<Integer, Boolean> parentList = new HashMap<>();
        TreeNode<Integer> currentN1 = n1;
        TreeNode<Integer> currentN2 = n2;
        while (currentN1 != null) {
            parentList.put(currentN1.val, true);
            currentN1 = currentN1.parent;
        }
        while (currentN2 != null) {
            if (parentList.getOrDefault(currentN2.val, false)) {
                return currentN2;
            }
            currentN2 = currentN2.parent;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);

        node3.left = node4;
        node3.right = node6;
        node4.parent = node3;
        node6.parent = node3;

        node4.left = node5;
        node4.right = node9;
        node5.parent = node4;
        node9.parent = node4;

        node6.right = node7;
        node7.parent = node6;

        LowestCommonAncestorParent opt = new LowestCommonAncestorParent();
        TreeNode lcaParent = opt.lcaParent(node5, node9);
        System.out.println(lcaParent.val);

    }
}
