package com.kensbunker.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.tree.TreeNode;

public class ValidBinarySearchTreeBFS {

  public boolean isValidBst(TreeNode node) {
    if (node == null) {
      return true;
    }
    Queue<AugmentedNode> queue = new LinkedList<>();
    queue.add(new AugmentedNode(node, Integer.MIN_VALUE, Integer.MAX_VALUE));

    while (!queue.isEmpty()) {
      AugmentedNode augmentedNode = queue.poll();
      MyNode currentNode = (MyNode) augmentedNode.node;
      if (currentNode.getValue() < augmentedNode.min || currentNode.getValue() > augmentedNode.max) {
        return false;
      }
      TreeNode left = currentNode.getChildAt(0);
      TreeNode right = currentNode.getChildAt(1);
      if (left != null) {
        queue.add(new AugmentedNode(left, augmentedNode.min, currentNode.getValue()));
      }
      if (right != null) {
        queue.add(new AugmentedNode(right, currentNode.getValue(), augmentedNode.max));
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
    MyNode node_1 = new MyNode(-1);
    MyNode node1 = new MyNode(1);
    MyNode node1_2 = new MyNode(1);
    MyNode node2 = new MyNode(2);
    MyNode node2_2 = new MyNode(2);
    MyNode node2_3 = new MyNode(2);
    MyNode node2_4 = new MyNode(2);
    MyNode node3 = new MyNode(3);
    MyNode node4 = new MyNode(4);
    MyNode node5 = new MyNode(5);
    MyNode node5_2 = new MyNode(5);
    MyNode node6 = new MyNode(6);
    MyNode node7 = new MyNode(7);

    node2.setChildren(Arrays.asList(node1, node4));
    node1.setParent(node2);
    node4.setParent(node2);

    node4.setChildren(Arrays.asList(node3, node5));
    node3.setParent(node4);
    node5.setParent(node4);

    ValidBinarySearchTreeBFS s = new ValidBinarySearchTreeBFS();
    System.out.println( s.isValidBst(node2));

  }
}
