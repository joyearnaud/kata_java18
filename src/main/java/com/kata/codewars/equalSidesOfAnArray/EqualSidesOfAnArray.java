package com.kata.codewars.equalSidesOfAnArray;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
interface TriFunction<T, U, V, R> {

    R apply(T t, U u, V v);

    default <K> TriFunction<T, U, V, K> andThen(Function<? super R, ? extends K> after) {
        Objects.requireNonNull(after);
        return (T t, U u, V v) -> after.apply(apply(t, u, v));
    }
}


public class EqualSidesOfAnArray {

    static private final TriFunction<int[], Integer, Integer, Integer> getSum =
            (array, left, right) -> Arrays.stream(Arrays.copyOfRange(array, left, right)).sum();

    public static int findEvenIndex(int[] arr) {

        if (null == arr) return -1;

        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(getSum.apply(arr, 0, i), getSum.apply(arr, i + 1, size))) return i;
        }

        return -1;
    }

    public static int findEvenIndex2(int[] arr) {
        if (null == arr) return -1;

        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(Arrays.stream(arr, 0, i).sum(), Arrays.stream(arr, i + 1, size).sum())) {
                return i;
            }
        }

        return -1;
    }
}
