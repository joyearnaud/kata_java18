package com.kata.codewars.romanNumeral;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.valueOf;

public class RomanNumerals {

    public static class BiMap {
        Map<String, Integer> stringHashMap = new TreeMap<>();
        Map<Integer, String> intHashMap = new TreeMap<>();

        public void put(String key, Integer value) {
            if (!stringHashMap.containsValue(value) && !intHashMap.containsValue(key)) {
                stringHashMap.put(key, value);
                intHashMap.put(value, key);
            }
        }

        public Integer convert(String s) {
            return stringHashMap.get(s);
        }

        public String convert(Integer i) {
            return intHashMap.get(i);
        }

        public Integer biggest(Integer max) {
            Map.Entry<Integer, String> integerStringEntry = intHashMap.entrySet().stream().filter(i -> i.getKey() < max).reduce((first, second) -> second).orElse(null);
            return integerStringEntry == null ? 1 : integerStringEntry.getKey();
        }
    }

    public static BiMap init() {
        BiMap biMap = new BiMap();
        biMap.put("I", 1);
        biMap.put("IV", 4);
        biMap.put("V", 5);
        biMap.put("IX", 9);
        biMap.put("X", 10);
        biMap.put("XL", 40);
        biMap.put("L", 50);
        biMap.put("XC", 90);
        biMap.put("C", 100);
        biMap.put("CD", 400);
        biMap.put("D", 500);
        biMap.put("CM", 900);
        biMap.put("M", 1000);

        return biMap;
    }

    public static String toRoman(int n) {
        StringBuilder stringBuilder = new StringBuilder();

        BiMap biMap = init();

        int length = valueOf(n).length();
        int[] ints = Integer.toString(n).chars().map(c -> c - '0').toArray();
        for (int anInt : ints) {
            if (anInt != 0) {
                int pow = (int) Math.pow(10, (length - 1));
                appendC(stringBuilder, biMap, anInt * pow, pow);
            }
            length--;
        }

        return stringBuilder.toString();
    }

    private static void appendC(StringBuilder stringBuilder, BiMap biMap, int part, int pow) {
        String convert = biMap.convert(part);
        boolean isInSpecialRule = (part + pow) % (5 * pow) == 0;

        if (convert != null) {/*1; 5; 10; 50; 100; 500; 1000*/
            stringBuilder.append(convert);
            return;
        }
//        else if (isInSpecialRule) {/*4 => IV ; 9 => IX*/
//            stringBuilder.append(biMap.convert(pow)).append(biMap.convert(part + pow));
//            return;
//        }

        int biggest = biMap.biggest(part);
        double xtime = (double) part / biggest;
        String bConverted = biMap.convert(biggest);

        boolean isInteger = Math.abs(Math.floor(xtime) - xtime) < 1E-5;
        if (isInteger)
            stringBuilder.append(IntStream.iterate(0, y -> y < xtime, y -> y + 1).mapToObj(y -> bConverted).collect(Collectors.joining()));
        else {
            int partLessBiggest = part - biggest;
            appendC(
                    stringBuilder.append(bConverted),
                    biMap,
                    partLessBiggest,
                    (int) Math.pow(10, valueOf(partLessBiggest).length() - 1)
            );
        }

    }

    public static int fromRoman(String romanNumeral) {
        BiMap biMap = init();
        int res = 0;

        Integer integer = biMap.stringHashMap.get(romanNumeral);
        if (integer != null) return integer;
        else {
            char[] charArray = romanNumeral.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                String s = i == charArray.length - 2 ? String.valueOf(c + charArray[i + 1]) : valueOf(c);
                res += biMap.convert(s) != null ? biMap.convert(s) : biMap.convert(valueOf(c));
            }
            return res;
        }
    }
}
