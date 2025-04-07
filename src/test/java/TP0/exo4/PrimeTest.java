package TP0.exo4;


import TP0.exo4.Prime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
;


public class PrimeTest {



        @Test
        public void testNegativeNumbers() {
            assertFalse(Prime.isPrime(-5));
        }

        @Test
        public void testZero() {
            assertFalse(Prime.isPrime(0));
        }

        @Test
        public void testOne() {
            assertFalse(Prime.isPrime(1));
        }

        @Test
        public void testTwo() {
            assertTrue(Prime.isPrime(2));
        }
        @Test
        public void testLargePrime() {
            assertTrue(Prime.isPrime(997));
        }

        @Test
        public void testLargeNonPrime() {
            assertFalse(Prime.isPrime(999));
        }

        @Test
        public void testPerfectSquare() {
            assertFalse(Prime.isPrime(25));
        }



}