package com.kata.codewars.largeFactorials;

import org.junit.jupiter.api.Test;

import static com.kata.codewars.largeFactorials.LargeFactorials.Factorial;
import static org.junit.jupiter.api.Assertions.*;

class LargeFactorialsTest {
    @Test
    public void BasicTests()
    {
        assertEquals("1", Factorial(1));
        assertEquals("120", Factorial(5));
        assertEquals("362880", Factorial(9));
        assertEquals("1307674368000", Factorial(15));
    }
}