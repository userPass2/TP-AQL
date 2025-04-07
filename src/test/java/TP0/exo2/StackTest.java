package TP0.exo2;


import TP0.exo2.Stack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    public void testPushAndPeek() {
        Stack stack = new Stack();
        stack.push(56);
        assertEquals(56, stack.peek(), "sommet de la pile est 42");
    }

    @Test
    public void testPushAndPop() {
        Stack stack = new Stack();
        stack.push(56);
        int value = stack.pop();
        assertEquals(56, value);
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty(), "pile vide");
        stack.push(56);
        assertFalse(stack.isEmpty(), "pile non vide");
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void TestSize() {
        Stack stack = new Stack();
        stack.push(29);
        stack.push(56);
        stack.push(42);
        assertEquals(stack.size(), 3);
    }
}