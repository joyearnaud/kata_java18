package com.kata.codewars.romanNumeral;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralsTest {

    @Test
    public void testToRoman() throws Exception {
        assertEquals ("I", RomanNumerals.toRoman(1), "1 converts to 'I'");
        assertEquals("II", RomanNumerals.toRoman(2), "2 converts to 'II'");
        assertEquals("MLXXX", RomanNumerals.toRoman(1080), "1080 converts to 'MLXXX'");
        assertEquals("DLXX", RomanNumerals.toRoman(570), "1080 converts to 'DLXX'");
        assertEquals("IV", RomanNumerals.toRoman(4), "4 converts to 'IV'");
        assertEquals("XL", RomanNumerals.toRoman(40), "40 converts to 'XL'");
        assertEquals("XLVIII", RomanNumerals.toRoman(48), "48 converts to 'XLVIII'");
        assertEquals("MCMXC", RomanNumerals.toRoman(1990), "1990 converts to 'MCMXC'");
        assertEquals("MMVIII", RomanNumerals.toRoman(2008), "2008 converts to 'MMVIII'");
        assertEquals("MDCLXVI", RomanNumerals.toRoman(1666), "1666 converts to 'MDCLXVI'");
    }

/*    @Test
    public void testFromRoman() throws Exception {
        assertEquals(RomanNumerals.fromRoman("I"), 1, "'I' converts to 1");
        assertEquals(RomanNumerals.fromRoman("II"), 2, "'II' converts to 2");
    }*/
}