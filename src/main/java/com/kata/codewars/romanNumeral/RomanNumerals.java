package com.kata.codewars.romanNumeral;

import java.util.Map;
import java.util.TreeMap;

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
        biMap.put("V", 5);
        biMap.put("X", 10);
        biMap.put("L", 50);
        biMap.put("C", 100);
        biMap.put("D", 500);
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
                appendC(stringBuilder, biMap, anInt * (int) Math.pow(10, (length - 1)));
            }
            length--;
        }

        return stringBuilder.toString();
    }

    private static void appendC(StringBuilder stringBuilder, BiMap biMap, int part) {
        String convert = biMap.convert(part);
        int pow = (int) Math.pow(10, valueOf(part).length() - 1);

        boolean isInSpecialRule = (part + pow) % (5 * pow) == 0;
        if (convert != null) {
            stringBuilder.append(convert);
        } else if (isInSpecialRule) {
            stringBuilder.append(biMap.convert(pow)).append(biMap.convert(part + pow));
        } else {
            int biggest = biMap.biggest(part);
            double xtime = (double) part / biggest;
            String bConverted = biMap.convert(biggest);

            if (Math.abs(Math.floor(xtime) - xtime) < 1E-5) {
                for (int y = 0; y < xtime; y++) {
                    stringBuilder.append(bConverted);
                }
            } else {
                appendC(
                        stringBuilder.append(bConverted),
                        biMap,
                        part - biggest);
            }
        }
    }

    public static int fromRoman(String romanNumeral) {
        return 1;
    }
}
