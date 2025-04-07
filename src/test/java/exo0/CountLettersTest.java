package exo0;

import TP0.exo0.CountLetters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CountLettersTest {
    @Test
    public void multipleMatchingWords() {
        int words = new CountLetters().count("cats|dogs");
        Assertions.assertEquals(2, words);
    }

    @Test
    public void lastWordDoesNotMatch() {
        int words = new CountLetters().count("cats|dog");
        Assertions.assertEquals(1, words);
    }


}