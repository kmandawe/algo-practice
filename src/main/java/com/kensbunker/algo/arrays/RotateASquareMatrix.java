package com.kensbunker.algo.arrays;

import java.util.Arrays;

public class RotateASquareMatrix {

  public int[][] rotate(int[][] matrix) {
    int size = matrix.length - 1;

    for (int layer = 0; layer < matrix.length / 2; layer++) {
      for (int i = layer; i < size - layer; i++) {
        int top = matrix[layer][i];
        int right = matrix[i][size - layer];
        int bottom = matrix[size - layer][size - i];
        int left = matrix[size - i][layer];

        matrix[layer][i] = left;
        matrix[i][size - layer] = top;
        matrix[size - layer][size - i] = right;
        matrix[size - i][layer] = bottom;
      }
    }

    return matrix;
  }

  public static void main(String[] args) {
    int[][] matrix = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    };

    int[][] matrix2 = {
        {10, 20},
        {30, 40}
    };

    RotateASquareMatrix opt = new RotateASquareMatrix();

    prettyPrint(opt.rotate(matrix));
    System.out.println();
    prettyPrint(opt.rotate(matrix2));
  }

  private static void prettyPrint(Object[] arr) {
    System.out.println(
        Arrays.deepToString(arr).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
  }
}
