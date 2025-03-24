package exo1;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @org.junit.jupiter.api.Test
    public void testGetFullName() {
        Person person = new Person("John", "Doe", 25);
        assertEquals("John Doe", person.getFullName());
    }

    @org.junit.jupiter.api.Test
    public void testIsAdultWhenAdult() {
        Person person = new Person("John", "Doe", 25);
        assertTrue(person.isAdult());
    }

    @org.junit.jupiter.api.Test
    public void testIsAdultWhenMinor() {
        Person person = new Person("Jane", "Doe", 16);
        assertFalse(person.isAdult());
    }



}