package com.kensbunker.algo;

public class FibonacciWithMemoization {
    public int fibo(int n) {
        int[] cache = new int[n];
        return fiboWithCache(n, cache);
    }

    private int fiboWithCache(int n, int[] cache) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (cache[n - 1] == 0) {
            cache[n - 1] = fiboWithCache(n - 1, cache) + fiboWithCache(n - 2, cache);
        }
        return cache[n - 1];
    }

    public static void main(String[] args) {
        FibonacciWithMemoization fibo = new FibonacciWithMemoization();
        System.out.println(fibo.fibo(14));
    }

}
