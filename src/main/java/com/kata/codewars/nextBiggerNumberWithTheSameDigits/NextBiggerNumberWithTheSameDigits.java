package com.kata.codewars.nextBiggerNumberWithTheSameDigits;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NextBiggerNumberWithTheSameDigits {
    public static final long BAD_RESPONSE = -1L;
    public static final int BAD_EXEC = -1;

    public static long nextBiggerNumber(long n) {
        String s = String.valueOf(n);
        int[] ints = IntStream.range(0, s.length()).map(i -> s.charAt(i) - '0').toArray();

        Map<Integer, Integer> map = IntStream.range(0, ints.length).map(i -> (ints.length - 1 - i)).boxed().collect(Collectors.toMap(i -> i, i -> getRest(ints, i)));

        Integer key = getMaxEntry(map).map(Map.Entry::getKey).orElse(BAD_EXEC);
        Integer value = map.get(key);

        if (BAD_EXEC == key || BAD_EXEC == value) return BAD_RESPONSE;
        int[] swap = swap(ints, key, value);
        int[] arrangeAndConcat = sortAndConcat(swap, value);
        String res = Arrays.toString(arrangeAndConcat).replaceAll("\\[|\\]|,|\\s", "");
        return Long.parseLong(res);
    }

    private static int getRest(int[] ints, int firstPos) {
        int pos = -1;

        for (int y = firstPos; y-- > 0; ) {
            if (ints[firstPos] > ints[y]) {
                pos = y;
                break;
            }
        }

        return pos;
    }

    private static Optional<Map.Entry<Integer, Integer>> getMaxEntry(Map<Integer, Integer> map) {
        return map.entrySet()
                .stream()
                .max((Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) -> e1.getValue()
                        .compareTo(e2.getValue() + 1)
                );
    }

    private static int[] swap(int[] ints, Integer key, Integer value) {
        int[] res = Arrays.copyOf(ints, ints.length);
        int t = res[key];
        res[key] = res[value];
        res[value] = t;

        return res;
    }

    private static int[] sortAndConcat(int[] ints, Integer value) {
        return IntStream.concat(
                        Arrays.stream(Arrays.copyOfRange(ints, 0, value + 1)),
                        Arrays.stream(Arrays.stream(Arrays.copyOfRange(ints, value + 1, ints.length))
                                .sorted()
                                .toArray()))
                .toArray();
    }
}
/*    public static long nextBiggerNumber(long n) {
        char[] chars = String.valueOf(Math.toIntExact(n)).toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if(chars[i] < chars[j]) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        System.out.print(new String(chars));
        return Long.parseLong(new String(chars));
    }*/
