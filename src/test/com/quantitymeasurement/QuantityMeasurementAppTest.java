package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.quantitymeasurement.QuantityMeasurementApp.Feet;

public class QuantityMeasurementAppTest {

    @Test
    void testFeetEquality_SameValue() {

        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);

        assertEquals(feet1, feet2);
    }

    @Test
    void testFeetEquality_DifferentValue() {

        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(2.0);

        assertNotEquals(feet1, feet2);
    }

    @Test
    void testFeetEquality_NullComparison() {

        Feet feet = new Feet(1.0);

        assertNotEquals(null, feet);
    }

    @Test
    void testFeetEquality_SameReference() {

        Feet feet = new Feet(1.0);

        assertEquals(feet, feet);
    }
}