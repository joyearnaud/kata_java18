package com.kata.codewars.maskify;

public class Maskify {
    public static String maskify(String str) {
        if (str == null) return null;
        int strl = str.length();
        if (strl < 5) return str;
        return "#".repeat(strl - 4) + str.substring(strl - 4, strl);
    }
}
