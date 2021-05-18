package com.kensbunker.algo.trees;

public class MinHeightBstFromSortedArray {

    public TreeNode buildDriver(int[] input) {
        return build(input, 0, input.length);
    }

    private TreeNode build(int[] input, int start, int end) {
        if (start >= end) {
            return null;
        }
        int middle = start + ((end - start) / 2);
        TreeNode node = new TreeNode(input[middle]);
        TreeNode left = build(input, start, middle);
        TreeNode right = build(input, middle + 1, end);

        node.left = left;
        node.right = right;

        return node;
    }

    public static void main(String[] args) {
        MinHeightBstFromSortedArray opt = new MinHeightBstFromSortedArray();
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        TreeNode generated = opt.buildDriver(input);
        SerializeDeserialize serializer = new SerializeDeserialize();
        System.out.println(serializer.serialize(generated));
    }
}
