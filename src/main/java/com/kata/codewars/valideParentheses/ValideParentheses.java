package com.kata.codewars.valideParentheses;

import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class ValideParentheses {
    public static String openingParenthese = "(";
    public static String closingParenthese = ")";

    public static boolean validParentheses(String parens) {
        if(null == parens || parens.isEmpty()) return true;

        List<String> parentheses = Stream.of(parens.split("")).filter(s -> openingParenthese.equals(s) || closingParenthese.equals(s)).toList();
        if (0 == parentheses.size()) return true;

        int openingFrequency = Collections.frequency(parentheses, openingParenthese);
        int closingFrequency = Collections.frequency(parentheses, closingParenthese);
        if (openingFrequency != closingFrequency || closingParenthese.equals(parentheses.get(0))) return false;

        Stack<String> lifoString = new Stack<>();
        for (var p : parentheses) {
            if (openingParenthese.equals(p)) {
                lifoString.push(p);
            } else if (!lifoString.isEmpty()) {
                lifoString.pop();
            }
        }

        return lifoString.isEmpty();
    }
}
