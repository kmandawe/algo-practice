package com.kensbunker.algo;

import com.kensbunker.algo.trees.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ShortestPathUnweighted {

    public int shortestPath(TreeNode<String> root, String source, String path) throws Exception {
        Map<String, NodeDetails> distanceTable = buildDistanceTable(root);
        return getShortestDistance(distanceTable, source, path);
    }

    private int getShortestDistance(Map<String, NodeDetails> distanceTable, String source, String path) throws Exception {
        if (!distanceTable.containsKey(path)) {
            throw new Exception("Path doesn't exist");
        }
        NodeDetails current = distanceTable.get(path);
        int distance = 0;
        while (!source.equals(current.previous)) {
            distance += current.distance;
            current = distanceTable.get(current.previous);
        }
        return distance;
    }

    private Map<String, NodeDetails> buildDistanceTable(TreeNode<String> root) {
        Map<String, NodeDetails> distanceTable = new HashMap<>();
        Queue<NodeAndPrevious> helperQueue = new LinkedList<>();
        helperQueue.add(new NodeAndPrevious(root, null));

        while (!helperQueue.isEmpty()) {
           NodeAndPrevious current = helperQueue.poll();
            String previous = current.previous;
            if (previous == null) {
                distanceTable.put(current.node.val, new NodeDetails(0, current.node.val));

            } else if (!distanceTable.containsKey(current.node.val)) {
                int distance = distanceTable.get(previous).distance + 1;
                    distanceTable.put(current.node.val, new NodeDetails(distance, previous));
            }
            if (current.node.left != null) {
                helperQueue.add(new NodeAndPrevious(current.node.left, current.node.val));
            }
            if (current.node.right != null) {
                helperQueue.add(new NodeAndPrevious(current.node.right, current.node.val));
            }
        }
        return distanceTable;
    }

    private class NodeDetails {
        int distance;
        String previous;

        NodeDetails(int distance, String previous) {
            this.distance = distance;
            this.previous = previous;
        }
    }

    private class NodeAndPrevious {
        TreeNode<String> node;
        String previous;

        NodeAndPrevious(TreeNode<String> node, String previous) {
            this.node = node;
            this.previous = previous;
        }
    }

    public static void main(String[] args) throws Exception {
        TreeNode<String> nodeA = new TreeNode<>("A");
        TreeNode<String> nodeB = new TreeNode<>("B");
        TreeNode<String> nodeC = new TreeNode<>("C");
        TreeNode<String> nodeD = new TreeNode<>("D");
        TreeNode<String> nodeE = new TreeNode<>("E");

        nodeA.left = nodeC;
        nodeA.right = nodeB;

        nodeC.left = nodeE;

        nodeB.left = nodeD;

        nodeE.left = nodeB;
        nodeE.right = nodeD;

        ShortestPathUnweighted opt = new ShortestPathUnweighted();
        System.out.println(opt.shortestPath(nodeA, "A", "D"));

    }
}
