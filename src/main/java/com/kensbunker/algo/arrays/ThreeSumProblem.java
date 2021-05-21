package com.kensbunker.algo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumProblem {

  private List<List<Integer>> threeSum(int[] input) {
    Set<List<Integer>> threeSumSet = new HashSet<>();
    Arrays.sort(input);
    int secondToTheLastIndex = input.length - 2;
    for (int i = 0; i < secondToTheLastIndex; i++) {
      findTwoSum(i, input, threeSumSet);
    }
    return new ArrayList<>(threeSumSet);
  }

  private void findTwoSum(int startIndex, int[] input, Set<List<Integer>> threeSumSet) {
    int left = startIndex + 1;
    int right = input.length - 1;
    while (left < right) {
      int currentSum = input[startIndex] + input[left] + input[right];
      if (currentSum == 0){
        threeSumSet.add(Arrays.asList(input[startIndex], input[left++], input[right--]));
      }
      if (currentSum < 0){
        left++;
      }
      if (currentSum > 0) {
        right--;
      }
    }
  }


  public static void main(String[] args) {
    int[] input = {-3, -1, 1, 0, 2, 10, -2, 8};
    ThreeSumProblem opt = new ThreeSumProblem();
    System.out.println(opt.threeSum(input));
  }
}
