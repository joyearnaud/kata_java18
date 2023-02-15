package com.kata.codewars.romanNumeral;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.valueOf;
import static java.util.stream.IntStream.iterate;

public class RomanNumerals {
    private static final Object[][] values = {{"I", 1}, {"IV", 4}, {"V", 5}, {"IX", 9}, {"X", 10}, {"XL", 40}, {"L", 50}, {"XC", 90}, {"C", 100}, {"CD", 400}, {"D", 500}, {"CM", 900}, {"M", 1000}};

    private static final class BiMap {
        Map<String, Integer> stringHashMap = new TreeMap<>();
        Map<Integer, String> intHashMap = new TreeMap<>();

        public BiMap(Object[][] values) {
            Map<String, Integer> map = Stream.of(values).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));
            map.forEach(this::put);
        }

        private void put(String key, Integer value) {
            if (!stringHashMap.containsValue(value) && !intHashMap.containsValue(key)) {
                stringHashMap.put(key, value);
                intHashMap.put(value, key);
            }
        }

        public Integer convert(String s) {
            return stringHashMap.get(s);
        }

        public String convert(int i) {
            return intHashMap.get(i);
        }

        public Integer biggest(int max) {
            Entry<Integer, String> integerStringEntry = intHashMap.entrySet().stream().filter(i -> i.getKey() < max).reduce((first, second) -> second).orElse(null);
            return integerStringEntry == null ? 1 : integerStringEntry.getKey();
        }
    }

    private static final BiMap biMap = new BiMap(values);

    public static String toRoman(int n) {
        StringBuilder stringBuilder = new StringBuilder();

        int length = valueOf(n).length();
        for (int anInt : Integer.toString(n).chars().map(c -> c - '0').toArray()) {
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

        if (convert != null) {
            stringBuilder.append(convert);
            return;
        }

        int biggest = biMap.biggest(part);
        double xtime = (double) part / biggest;
        String bConverted = biMap.convert(biggest);

        boolean isInteger = (xtime % 1) == 0;
        if (isInteger)
            stringBuilder.append(iterate(0, y -> y < xtime, y -> y + 1).mapToObj(y -> bConverted).collect(Collectors.joining()));
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
        int res = 0;

        Integer integer = biMap.stringHashMap.get(romanNumeral);
        if (integer != null) return integer;
        else {
            char[] charArray = romanNumeral.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                char cNext = i < charArray.length - 1 ? charArray[i + 1] : " ".charAt(0);

                Integer convert = biMap.convert(String.valueOf(c) + cNext);
                if (convert == null) res += biMap.convert(valueOf(c));
                else {
                    res += convert;
                    i++;
                }
            }

            return res;
        }
    }
}
