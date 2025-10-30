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
    void deleteCity_noop_whenCityNotPresent() {
        CustomList list = new CustomList();
        list.addCity(new City("Calgary", "AB"));

        list.deleteCity(new City("Vancouver", "BC"));

        assertEquals(1, list.countCities(), "Deleting absent city shouldn't change size");
    }
}