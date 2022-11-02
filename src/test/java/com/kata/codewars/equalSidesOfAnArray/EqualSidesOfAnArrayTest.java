package com.kata.codewars.equalSidesOfAnArray;

import org.junit.jupiter.api.Test;

import static com.kata.codewars.equalSidesOfAnArray.EqualSidesOfAnArray.findEvenIndex;
import static com.kata.codewars.equalSidesOfAnArray.EqualSidesOfAnArray.findEvenIndex2;
import static org.junit.jupiter.api.Assertions.*;

class EqualSidesOfAnArrayTest {
    @Test
    public void test() {
        assertEquals(3,findEvenIndex(new int[] {1,2,3,4,3,2,1}));
        assertEquals(1,findEvenIndex(new int[] {1,100,50,-51,1,1}));
        assertEquals(-1,findEvenIndex(new int[] {1,2,3,4,5,6}));
        assertEquals(3,findEvenIndex(new int[] {20,10,30,10,10,15,35}));
        assertEquals(-1,findEvenIndex(new int[] {-8505, -5130, 1926, -9026}));
        assertEquals(1,findEvenIndex(new int[] {2824, 1774, -1490, -9084, -9696, 23094}));
        assertEquals(6,findEvenIndex(new int[] {4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));
        assertEquals(-1,findEvenIndex(null));
        assertEquals(-1,findEvenIndex(new int[]{}));
    }

    @Test
    public void test2() {
        assertEquals(3,findEvenIndex2(new int[] {1,2,3,4,3,2,1}));
        assertEquals(1,findEvenIndex2(new int[] {1,100,50,-51,1,1}));
        assertEquals(-1,findEvenIndex2(new int[] {1,2,3,4,5,6}));
        assertEquals(3,findEvenIndex2(new int[] {20,10,30,10,10,15,35}));
        assertEquals(-1,findEvenIndex2(new int[] {-8505, -5130, 1926, -9026}));
        assertEquals(1,findEvenIndex2(new int[] {2824, 1774, -1490, -9084, -9696, 23094}));
        assertEquals(6,findEvenIndex2(new int[] {4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));
        assertEquals(-1,findEvenIndex2(null));
        assertEquals(-1,findEvenIndex2(new int[]{}));
    }
}