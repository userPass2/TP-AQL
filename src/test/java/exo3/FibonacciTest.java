package exo3;

import TP0.exo3.Fibonacci;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciTest {

        @Test
        public void testFibonacciWithNegativeInput() {
            assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(-1));
        }

        @Test
        public void testFibonacciZero() {
            assertEquals(0, Fibonacci.fibonacci(0));
        }

        @Test
        public void testFibonacciOne() {
            assertEquals(1, Fibonacci.fibonacci(1));
        }

        @Test
        public void testFibonacciTwo() {
            assertEquals(1, Fibonacci.fibonacci(2));
        }

        @Test
        public void testFibonacciThree() {

            assertEquals(2, Fibonacci.fibonacci(3));
        }

        @Test
        public void testFibonacciFour() {
            assertEquals(3, Fibonacci.fibonacci(4));
        }

        @Test
        public void testFibonacciFive() {
            assertEquals(5, Fibonacci.fibonacci(5));
        }

        @Test
        public void testFibonacciTen() {
            assertEquals(55, Fibonacci.fibonacci(10));
        }

        @Test
        public void testFibonacciTwenty() {
            assertEquals( 6765, Fibonacci.fibonacci(20));
        }

        @Test
        public void testSequence() {
            int[] expectedSequence = {
                    0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181
            };

            for (int i = 0; i < expectedSequence.length; i++) {
                assertEquals(expectedSequence[i], Fibonacci.fibonacci(i),
                        "Valeur incorrecte de Fibonacci à la position " + i);
            }
        }
}