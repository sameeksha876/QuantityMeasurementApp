package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.quantitymeasurement.QuantityMeasurementApp.Length;
import com.quantitymeasurement.QuantityMeasurementApp.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    void testEquality_YardToYard_SameValue() {

        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        Length yard2 = new Length(1.0, LengthUnit.YARDS);

        assertEquals(yard1, yard2);
    }

    @Test
    void testEquality_YardToYard_DifferentValue() {

        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        Length yard2 = new Length(2.0, LengthUnit.YARDS);

        assertNotEquals(yard1, yard2);
    }

    @Test
    void testEquality_YardToFeet_EquivalentValue() {

        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);

        assertEquals(yard, feet);
    }

    @Test
    void testEquality_FeetToYard_EquivalentValue() {

        Length feet = new Length(3.0, LengthUnit.FEET);
        Length yard = new Length(1.0, LengthUnit.YARDS);

        assertEquals(feet, yard);
    }

    @Test
    void testEquality_YardToInches_EquivalentValue() {

        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length inches = new Length(36.0, LengthUnit.INCHES);

        assertEquals(yard, inches);
    }

    @Test
    void testEquality_InchesToYard_EquivalentValue() {

        Length inches = new Length(36.0, LengthUnit.INCHES);
        Length yard = new Length(1.0, LengthUnit.YARDS);

        assertEquals(inches, yard);
    }

    @Test
    void testEquality_CentimetersToInches_EquivalentValue() {

        Length centimeters = new Length(1.0, LengthUnit.CENTIMETERS);
        Length inches = new Length(0.393701, LengthUnit.INCHES);

        assertEquals(centimeters, inches);
    }

    @Test
    void testEquality_CentimetersToFeet_NonEquivalentValue() {

        Length centimeters = new Length(1.0, LengthUnit.CENTIMETERS);
        Length feet = new Length(1.0, LengthUnit.FEET);

        assertNotEquals(centimeters, feet);
    }

    @Test
    void testEquality_SameReference() {

        Length length = new Length(1.0, LengthUnit.YARDS);

        assertEquals(length, length);
    }

    @Test
    void testEquality_NullComparison() {

        Length length = new Length(1.0, LengthUnit.CENTIMETERS);

        assertNotEquals(null, length);
    }

    @Test
    void testEquality_MultiUnit_TransitiveProperty() {

        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length inches = new Length(36.0, LengthUnit.INCHES);

        assertEquals(yard, feet);
        assertEquals(feet, inches);
        assertEquals(yard, inches);
    }
}