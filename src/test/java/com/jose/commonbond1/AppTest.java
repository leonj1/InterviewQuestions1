package com.jose.commonbond1;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {


    public void testFullAlphabetExpectEmptyString() {
        // given
        String underTest = "abcdefghijklmnopqrstuvwxyz";

        // when
        String result = App.listMissingLetters(underTest);

        // then
        assertEquals("", result);
    }

    public void testAQuickBrownFox() {
        // given
        String underTest = "A quick brown fox jumps over the lazy dog";

        // when
        String result = App.listMissingLetters(underTest);

        // then
        assertEquals("", result);
    }

    public void testFourScore() {
        // given
        String underTest = "Four score and seven years ago.";

        // when
        String result = App.listMissingLetters(underTest);

        // then
        assertEquals("bhijklmpqtwxz", result);
    }

    public void testToBeOrNot() {
        // given
        String underTest = "To be or not to be, that is the question!";

        // when
        String result = App.listMissingLetters(underTest);

        // then
        assertEquals("cdfgjklmpvwxyz", result);
    }

    public void testEmptyString() {
        // given
        String underTest = "";

        // when
        String result = App.listMissingLetters(underTest);

        // then
        assertEquals("abcdefghijklmnopqrstuvwxyz", result);
    }

    public void testHandleNulls() {
        // given
        String underTest = null;

        // then
        try {
            App.listMissingLetters(underTest);
            fail("Should throw Exception if null is passed in.");
        } catch (Exception e) {
            // good
        }
    }
}
