package com.kata.codewars.largeFactorials;

import java.math.BigInteger;

public class LargeFactorials {
    public static String Factorial(int n) {
        return String.valueOf(act(n, BigInteger.valueOf(1)));
    }

    public static BigInteger act(int n, BigInteger rest) {
        return 0 == n ? rest : act(n - 1, rest.multiply(BigInteger.valueOf(n)));
    }
}
