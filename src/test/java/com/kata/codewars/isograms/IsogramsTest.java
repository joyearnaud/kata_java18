package com.kata.codewars.isograms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsogramsTest {

    @Test
    public void FixedTests() {
        assertTrue(Isograms.isIsogram("Dermatoglyphics"),"test1");
        assertTrue(Isograms.isIsogram("isogram"),"test2");
        assertFalse(Isograms.isIsogram("moose"),"test3");
        assertFalse(Isograms.isIsogram("isIsogram"),"test4");
        assertFalse(Isograms.isIsogram("aba"),"test5");
        assertFalse(Isograms.isIsogram("moOse"),"test6");
        assertTrue(Isograms.isIsogram("thumbscrewjapingly"),"test7");
        assertTrue(Isograms.isIsogram(""),"test8");
    }

    @Test
    public void FixedTests2() {
        assertTrue(Isograms.isIsogram2("Dermatoglyphics"),"test1");
        assertTrue(Isograms.isIsogram2("isogram"),"test2");
        assertFalse(Isograms.isIsogram2("moose"),"test3");
        assertFalse(Isograms.isIsogram2("isIsogram"),"test4");
        assertFalse(Isograms.isIsogram2("aba"),"test5");
        assertFalse(Isograms.isIsogram2("moOse"),"test6");
        assertTrue(Isograms.isIsogram2("thumbscrewjapingly"),"test7");
        assertTrue(Isograms.isIsogram2(""),"test8");
    }
}