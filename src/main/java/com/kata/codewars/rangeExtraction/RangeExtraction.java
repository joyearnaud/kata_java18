package com.kata.codewars.rangeExtraction;

import java.util.*;
import java.util.AbstractMap.SimpleImmutableEntry;

public class RangeExtraction {
    public static String rangeExtraction(int[] arr) {
        StringBuilder res = new StringBuilder();
        ArrayList<Integer> stash = new ArrayList<>();
        for (int i = 1; i < arr.length + 1; i++) {
            SimpleImmutableEntry<Integer, Integer> c = new SimpleImmutableEntry<>(arr[i - 1], arr[i == arr.length ? i - 1 : i]);
            if (c.getKey() + 1 == c.getValue()) {
                stash.addAll(toStash(stash, c));
            } else {
                res.append(toAppend(stash, c));
                if (i != arr.length) res.append(",");
                stash.clear();
            }
        }

        return res.toString();
    }

    private static ArrayList<Integer> toStash(ArrayList<Integer> oldStash, SimpleImmutableEntry<Integer, Integer> c) {
        ArrayList<Integer> newStash = new ArrayList<>();

        if (oldStash.isEmpty()) newStash.add(c.getKey());
        newStash.add(c.getValue());

        return newStash;
    }

    private static StringBuilder toAppend(ArrayList<Integer> stash, SimpleImmutableEntry<Integer, Integer> c) {
        StringBuilder res = new StringBuilder();

        if (stash.isEmpty()) res.append(c.getKey());
        else res.append(stash.get(0))
                .append(stash.size() == 2 ? "," : "-")
                .append(stash.get(stash.size() - 1));

        return res;
    }
}
