package exo5;

import static org.junit.jupiter.api.Assertions.*;

import TP0.exo5.Factorial;
import org.junit.jupiter.api.Test;

class FactorialTest {

    @Test
    void testFactorialWithPositiveNumbers() {
        assertEquals(1, Factorial.factorial(1));
        assertEquals(2, Factorial.factorial(2));
        assertEquals(6, Factorial.factorial(3));
        assertEquals(24, Factorial.factorial(4));
        assertEquals(120, Factorial.factorial(5));
    }

    @Test
    void testFactorialWithZero() {
        assertEquals(1, Factorial.factorial(0));
    }

    @Test
    void testFactorialWithNegativeNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Factorial.factorial(-1);
        });
        assertEquals("n must be positive", exception.getMessage());
    }
}