package com.kata.codewars.createPhoneNumber;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreatePhoneNumber {
    static String openingParenthesis = "(";
    static String closingParenthesis = ")";
    static String space = " ";
    static String tiret = "-";

    public static String createPhoneNumber(int[] numbers) {

        String result = "";

        for (int i = 0; i < numbers.length; i++) {
            switch (i) {
                case 0:
                    result = result + openingParenthesis + numbers[i];
                    break;
                case 2:
                    result = result + numbers[i] + closingParenthesis + space;
                    break;
                case 6:
                    result = result + tiret + numbers[i];
                    break;
                default:
                    result = result + numbers[i];
                    break;
            }
        }

        return result;
    }

    public static String createPhoneNumber2(int[] numbers) {
        return "("+numbers[0]+numbers[1]+numbers[2]+") "+numbers[3]+numbers[4]+numbers[5]+"-"+numbers[6]+numbers[7]+numbers[8]+numbers[9];
    }
}
