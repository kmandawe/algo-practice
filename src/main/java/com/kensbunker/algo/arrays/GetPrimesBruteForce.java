package com.kensbunker.algo.arrays;

import java.util.ArrayList;
import java.util.List;

public class GetPrimesBruteForce {

  private List<Integer> getPrimes(int n) {
    List<Integer> primes = new ArrayList<>();
    if (n == 0 || n == 1) {
      return primes;
    }

    for (int i = 2; i < n; i++) {
      boolean isPrime = true;
      for (int j = 2; j < i; j++) {
        if (i % j == 0) {
          isPrime = false;
        }
      }
      if (isPrime) {
        primes.add(i);
      }
    }
    return primes;
  }

  public static void main(String[] args) {
    int n = 23;
    GetPrimesBruteForce opt = new GetPrimesBruteForce();
    System.out.println(opt.getPrimes(n));
  }
}
