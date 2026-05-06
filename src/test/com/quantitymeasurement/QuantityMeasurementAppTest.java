package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.quantitymeasurement.QuantityMeasurementApp.Length;
import com.quantitymeasurement.QuantityMeasurementApp.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    void testEquality_FeetToFeet_SameValue() {

        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length feet2 = new Length(1.0, LengthUnit.FEET);

        assertEquals(feet1, feet2);
    }

    @Test
    void testEquality_InchToInch_SameValue() {

        Length inch1 = new Length(1.0, LengthUnit.INCHES);
        Length inch2 = new Length(1.0, LengthUnit.INCHES);

        assertEquals(inch1, inch2);
    }

    @Test
    void testEquality_FeetToInch_EquivalentValue() {

        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);

        assertEquals(feet, inches);
    }

    @Test
    void testEquality_InchToFeet_EquivalentValue() {

        Length inches = new Length(12.0, LengthUnit.INCHES);
        Length feet = new Length(1.0, LengthUnit.FEET);

        assertEquals(inches, feet);
    }

    @Test
    void testEquality_FeetToFeet_DifferentValue() {

        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length feet2 = new Length(2.0, LengthUnit.FEET);

        assertNotEquals(feet1, feet2);
    }

    @Test
    void testEquality_InchToInch_DifferentValue() {

        Length inch1 = new Length(1.0, LengthUnit.INCHES);
        Length inch2 = new Length(2.0, LengthUnit.INCHES);

        assertNotEquals(inch1, inch2);
    }

    @Test
    void testEquality_SameReference() {

        Length length = new Length(1.0, LengthUnit.FEET);

        assertEquals(length, length);
    }

    @Test
    void testEquality_NullComparison() {

        Length length = new Length(1.0, LengthUnit.FEET);

        assertNotEquals(null, length);
    }
}