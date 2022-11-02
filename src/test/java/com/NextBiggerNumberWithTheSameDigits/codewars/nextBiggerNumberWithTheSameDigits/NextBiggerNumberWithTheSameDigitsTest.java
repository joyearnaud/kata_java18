package com.NextBiggerNumberWithTheSameDigits.codewars.nextBiggerNumberWithTheSameDigits;

import org.junit.jupiter.api.Test;

import static com.kata.codewars.nextBiggerNumberWithTheSameDigits.NextBiggerNumberWithTheSameDigits.nextBiggerNumber;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NextBiggerNumberWithTheSameDigitsTest {

    @Test
    public void basicTests() {
        assertEquals(21, nextBiggerNumber(12));
        assertEquals(125634, nextBiggerNumber(125463));
        assertEquals(531, nextBiggerNumber(513));
        assertEquals(2071, nextBiggerNumber(2017));
        assertEquals(441, nextBiggerNumber(414));
        assertEquals(414, nextBiggerNumber(144));
        assertEquals(19009, nextBiggerNumber(10990));
        assertEquals(355625156, nextBiggerNumber(355621655));
        assertEquals(-1, nextBiggerNumber(54321));
        assertEquals(-1, nextBiggerNumber(9876543210L));
    }
}