package com.example.lab08;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomListTest {
    @Test
    public void testHasCity() {
        CustomList list = new CustomList();
        City calgary = new City("Calgary", "AB");
        list.addCity(calgary);
        assertTrue(list.hasCity(calgary));
    }

    @Test
    void deleteCity_removesExistingCity() {
        CustomList list = new CustomList();
        City calgary = new City("Calgary", "AB");
        City edmonton = new City("Edmonton", "AB");
        list.addCity(calgary);
        list.addCity(edmonton);

        list.deleteCity(calgary);

        assertFalse(list.hasCity(calgary));
        assertTrue(list.hasCity(edmonton));
    }

    @Test
    void countCities_reflectsAddAndDelete() {
        CustomList list = new CustomList();
        assertEquals(0, list.countCities());

        City c1 = new City("Calgary", "AB");
        City c2 = new City("Edmonton", "AB");
        list.addCity(c1);
        list.addCity(c2);
        assertEquals(2, list.countCities());

        list.deleteCity(c1);
        assertEquals(1, list.countCities());
    }
}