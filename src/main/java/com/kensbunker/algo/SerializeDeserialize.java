package com.kensbunker.algo;

import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserialize {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "X,";
        }
        String left = serialize(root.getChildAt(0));
        String right = serialize(root.getChildAt(1));
        return ((MyNode)root).getValue() + "," + left + right;
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
        MyNode node = new MyNode(Integer.valueOf(val));
        MyNode leftNode = (MyNode) deserializeHelper(remaining);
        MyNode rightNode = (MyNode) deserializeHelper(remaining);
        node.setChildren(Arrays.asList(leftNode, rightNode));
        if (leftNode != null) {
            leftNode.setParent(node);
        }
        if (rightNode != null) {
            rightNode.setParent(node);
        }

        return node;
    }

    public static void main(String[] args) {
        MyNode node1 = new MyNode(1);
        MyNode node2 = new MyNode(2);
        MyNode node3 = new MyNode(3);
        MyNode node4 = new MyNode(4);
        MyNode node5 = new MyNode(5);
        MyNode node6 = new MyNode(6);
        MyNode node7 = new MyNode(7);

        node1.setChildren(Arrays.asList(node2, node3));
        node2.setParent(node1);
        node3.setParent(node1);

        node3.setChildren(Arrays.asList(node4, node5));
        node4.setParent(node3);
        node5.setParent(node3);

        node5.setChildren(Arrays.asList(node6));
        node6.setParent(node5);

        SerializeDeserialize s = new SerializeDeserialize();
        String serialized = s.serialize(node1);
        System.out.println(serialized);
        TreeNode deserialized = s.deserialize(serialized);
        System.out.println(deserialized);
    }
}
