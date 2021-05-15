package com.kensbunker.algo;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode node) {
        if (node == null) {
            return true;
        }
        return symmetricChildren(node.left, node.right);
    }

    private boolean symmetricChildren(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return left.val == right.val &&
                    symmetricChildren(left.right, right.left) &&
                    symmetricChildren(left.left, right.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node2_2 = new TreeNode(2);
        TreeNode node2_3 = new TreeNode(2);
        TreeNode node2_4 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);

        node4.left = node2;
        node4.right = node2_2;

        node2.left = node1;
        node2.right = node2_3;

        node2_2.left = node2_4;

        SymmetricTree s = new SymmetricTree();
        System.out.println(s.isSymmetric(null));
    }
}
