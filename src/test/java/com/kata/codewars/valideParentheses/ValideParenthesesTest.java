package com.kata.codewars.valideParentheses;

import org.junit.jupiter.api.Test;

import static com.kata.codewars.valideParentheses.ValideParentheses.validParentheses;
import static org.junit.jupiter.api.Assertions.*;

class ValideParenthesesTest {

    @Test
    public void sampleTest() {
        // assertEquals("expected", "actual");
        assertEquals(true,validParentheses( "" ));
        assertEquals(true,validParentheses( null ));
        assertEquals(true,validParentheses( "()" ));
        assertEquals(false,validParentheses( "())" ));
        assertEquals(true,validParentheses( "32423(sgsdg)" ));
        assertEquals(false,validParentheses( "(dsgdsg))2432" ));
        assertEquals(true,validParentheses( "adasdasfa" ));
        assertEquals(false,validParentheses( "())(" ));
        assertEquals(true,validParentheses( "(())" ));
        assertEquals(true,validParentheses( "(()()()())(())" ));
    }
}