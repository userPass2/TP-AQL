package anwer.TP1.exo1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {
    
    @Test
    public void testIsPalindrome() {
        assertTrue(Palindrome.isPalindrome("radar"));
        assertTrue(Palindrome.isPalindrome("level"));
        assertTrue(Palindrome.isPalindrome("deed"));
        assertTrue(Palindrome.isPalindrome(""));
        assertTrue(Palindrome.isPalindrome("a"));
    }
    
    @Test
    public void testIsNotPalindrome() {
        assertFalse(Palindrome.isPalindrome("hello"));
        assertFalse(Palindrome.isPalindrome("world"));
        assertFalse(Palindrome.isPalindrome("java"));
    }
    
    @Test
    public void testIsPalindromeWithSpaces() {
        assertTrue(Palindrome.isPalindrome("a man a plan a canal panama"));
        assertTrue(Palindrome.isPalindrome("was it a car or a cat i saw"));
    }
} 