package com.kensbunker.algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserialize {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "X,";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + right;
    }

    public TreeNode deserialize(String s) {
        String[] split = s.split(",");
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(split));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> remaining) {
        String val = remaining.poll();
        if ("X".equals(val)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        TreeNode leftNode = deserializeHelper(remaining);
        TreeNode rightNode = deserializeHelper(remaining);
        node.left = leftNode;
        node.right = rightNode;

        return node;
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

        SerializeDeserialize s = new SerializeDeserialize();
        String serialized = s.serialize(node1);
        System.out.println(serialized);
        TreeNode deserialized = s.deserialize(serialized);
        System.out.println(deserialized);
    }
}
