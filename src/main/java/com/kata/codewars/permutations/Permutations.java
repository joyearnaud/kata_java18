package com.kata.codewars.permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public static Set<String> heap(Integer listLength, char[] list, Set<String> strings) {
        if (1 == listLength) strings.add(String.valueOf(list));

        for (int index = 0; index < listLength; index++) {
            heap(listLength - 1, list, strings);
            permute(listLength, list, (listLength % 2 == 0) ? index : 0);
        }

        return strings;
    }

    private static void permute(Integer listLength, char[] list, int index) {
        char temp = list[listLength - 1];
        list[listLength - 1] = list[index];
        list[index] = temp;
    }

    public static List<String> singlePermutations(String s) {
        char[] chars = s.toCharArray();

        if (null == s || s.isEmpty()) return new ArrayList<>();
        if (1 == chars.length) return List.of(s);

        return heap(chars.length, chars, new HashSet<>()).stream().toList();
    }
}
