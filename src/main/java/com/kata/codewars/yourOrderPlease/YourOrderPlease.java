package com.kata.codewars.yourOrderPlease;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class YourOrderPlease {
    public static String order(String words) {
        String[] s = words.split(" ");
        List<String> strings = new ArrayList<>();
        IntConsumer add = i -> Arrays.stream(s).filter(value -> value.contains(String.valueOf(i))).forEach(strings::add);
        IntStream.range(0, s.length + 1).forEach(add);

        return String.join(" ", strings);
    }
}
