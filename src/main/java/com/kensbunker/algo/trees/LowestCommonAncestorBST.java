package com.kensbunker.algo.trees;

public class LowestCommonAncestorBST {

    public TreeNode lca(TreeNode<Integer> root, int x, int y) {
        if (x < root.val && y < root.val) {
            return lca(root.left, x, y);
        }
        if (x > root.val && y > root.val) {
            return lca(root.right, x, y);
        }
        return root;
    }
    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node25 = new TreeNode(25);
        TreeNode node27 = new TreeNode(27);
        TreeNode node50 = new TreeNode(50);
        TreeNode node80 = new TreeNode(80);
        TreeNode node100 = new TreeNode(100);
        TreeNode node101 = new TreeNode(101);

        node50.left = node25;
        node50.right = node100;

        node25.left = node1;
        node25.right = node27;

        node100.left = node80;
        node100.right = node101;

        LowestCommonAncestorBST opt = new LowestCommonAncestorBST();
        TreeNode lca = opt.lca(node50, 1, 101);
        System.out.println(lca.val);

        TreeNode lca2 = opt.lca(node50, 1, 27);
        System.out.println(lca2.val);
    }
}
