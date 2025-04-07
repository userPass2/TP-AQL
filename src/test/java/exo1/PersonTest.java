package exo1;

import static org.junit.jupiter.api.Assertions.*;
import  org.junit.jupiter.api.Test ;
class PersonTest {

    @Test
    public void testGetFullName() {
        Person person = new Person("azrty", "dell", 25);
        assertEquals("azrty dell", person.getFullName());
    }

    @Test
    public void testIsAdultWhenAdult() {
        Person person = new Person("azrty", "dell", 25);
        assertTrue(person.isAdult());
    }

    @Test
    public void testIsAdultWhenMinor() {
        Person person = new Person("azrty", "dell", 16);
        assertFalse(person.isAdult());
    }

    @Test
    public void testIsAdultWhenExactly18() {
        Person person = new Person("azrty", "dell", 18);
        assertTrue(person.isAdult());
    }




}