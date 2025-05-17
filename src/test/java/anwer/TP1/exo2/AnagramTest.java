package anwer.TP1.exo2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramTest {
    
    @Test
    public void testAreAnagrams() {
        assertTrue(Anagram.areAnagrams("listen", "silent"));
        assertTrue(Anagram.areAnagrams("triangle", "integral"));
        assertTrue(Anagram.areAnagrams("", ""));
        assertTrue(Anagram.areAnagrams("a", "a"));
    }
    
    @Test
    public void testAreNotAnagrams() {
        assertFalse(Anagram.areAnagrams("hello", "world"));
        assertFalse(Anagram.areAnagrams("java", "python"));
        assertFalse(Anagram.areAnagrams("test", "tests"));
    }
    
    @Test
    public void testAreAnagramsWithSpaces() {
        assertTrue(Anagram.areAnagrams("dormitory", "dirty room"));
        assertTrue(Anagram.areAnagrams("the eyes", "they see"));
    }
    
    @Test
    public void testAreAnagramsWithDifferentCases() {
        assertTrue(Anagram.areAnagrams("Listen", "Silent"));
        assertTrue(Anagram.areAnagrams("Java", "jAvA"));
    }
} 