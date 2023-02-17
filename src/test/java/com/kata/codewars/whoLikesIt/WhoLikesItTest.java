package com.kata.codewars.whoLikesIt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhoLikesItTest {
    @Test
    public void staticTests() {
        assertEquals("no one likes this", WhoLikesIt.whoLikesIt());
        assertEquals("Peter likes this", WhoLikesIt.whoLikesIt("Peter"));
        assertEquals("Jacob and Alex like this", WhoLikesIt.whoLikesIt("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", WhoLikesIt.whoLikesIt("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", WhoLikesIt.whoLikesIt("Alex", "Jacob", "Mark", "Max"));
        assertEquals("Alex, Jacob and 3 others like this", WhoLikesIt.whoLikesIt("Alex", "Jacob", "Mark", "Max", "Niusha"));
    }

    @Test
    public void staticTests2() {
        assertEquals("no one likes this", WhoLikesIt.whoLikesIt2());
        assertEquals("Peter likes this", WhoLikesIt.whoLikesIt2("Peter"));
        assertEquals("Jacob and Alex like this", WhoLikesIt.whoLikesIt2("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", WhoLikesIt.whoLikesIt2("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", WhoLikesIt.whoLikesIt2("Alex", "Jacob", "Mark", "Max"));
        assertEquals("Alex, Jacob and 3 others like this", WhoLikesIt.whoLikesIt2("Alex", "Jacob", "Mark", "Max", "Niusha"));
    }
}