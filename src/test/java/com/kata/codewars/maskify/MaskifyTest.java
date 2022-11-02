package com.kata.codewars.maskify;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaskifyTest {

    @Test
    void maskify() {
        assertEquals("############5616", Maskify.maskify("4556364607935616"));
        assertEquals("#######5616",      Maskify.maskify(     "64607935616"));
        assertEquals("1",                Maskify.maskify(               "1"));
        assertEquals("",                 Maskify.maskify(                ""));
        assertEquals(null,                 Maskify.maskify(                null));

        // "What was the name of your first pet?"
        assertEquals("##ippy",                                    Maskify.maskify("Skippy")                                  );
        assertEquals("####################################man!",  Maskify.maskify("Nananananananananananananananana Batman!"));
    }
}