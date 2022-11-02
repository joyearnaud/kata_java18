package com.kata.codewars.isograms;

import java.util.*;

public class Isograms {
    public static boolean  isIsogram(String str) {
        if(null == str || 0 == str.length()) return true;

        Set<String> strings = new HashSet<>();
        for (String part : str.toLowerCase().split("")) {
            if (strings.contains(part)) return false;
            strings.add(part);
        }

        return true;
    }

    public static boolean  isIsogram2(String str) {
        if (str == null || str.isEmpty()) return true;
        return str.length() == str.toLowerCase().chars().distinct().count();
    }
}
