package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.quantitymeasurement.QuantityMeasurementApp.Length;
import com.quantitymeasurement.QuantityMeasurementApp.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    void testAddition_ExplicitTargetUnit_Feet() {

        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length result =
                length1.add(length2, LengthUnit.FEET);

        assertEquals(
                new Length(2.0, LengthUnit.FEET),
                result);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Inches() {

        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length result =
                length1.add(length2, LengthUnit.INCHES);

        assertEquals(
                new Length(24.0, LengthUnit.INCHES),
                result);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Yards() {

        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length result =
                length1.add(length2, LengthUnit.YARDS);

        assertEquals(
                new Length(0.67, LengthUnit.YARDS),
                result);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Centimeters() {

        Length length1 = new Length(1.0, LengthUnit.YARDS);
        Length length2 = new Length(3.0, LengthUnit.FEET);

        Length result =
                length1.add(length2, LengthUnit.CENTIMETERS);

        assertEquals(
                new Length(182.88, LengthUnit.CENTIMETERS),
                result);
    }

    @Test
    void testAddition_ExplicitTargetUnit_SameAsFirstOperand() {

        Length length1 = new Length(2.0, LengthUnit.YARDS);
        Length length2 = new Length(3.0, LengthUnit.FEET);

        Length result =
                length1.add(length2, LengthUnit.YARDS);

        assertEquals(
                new Length(3.0, LengthUnit.YARDS),
                result);
    }

    @Test
    void testAddition_ExplicitTargetUnit_SameAsSecondOperand() {

        Length length1 = new Length(2.0, LengthUnit.YARDS);
        Length length2 = new Length(3.0, LengthUnit.FEET);

        Length result =
                length1.add(length2, LengthUnit.FEET);

        assertEquals(
                new Length(9.0, LengthUnit.FEET),
                result);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Commutativity() {

        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length result1 =
                length1.add(length2, LengthUnit.YARDS);

        Length result2 =
                length2.add(length1, LengthUnit.YARDS);

        assertEquals(result1, result2);
    }

    @Test
    void testAddition_ExplicitTargetUnit_WithZero() {

        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length zero = new Length(0.0, LengthUnit.INCHES);

        Length result =
                length1.add(zero, LengthUnit.YARDS);

        assertEquals(
                new Length(1.67, LengthUnit.YARDS),
                result);
    }

    @Test
    void testAddition_ExplicitTargetUnit_NegativeValues() {

        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length length2 = new Length(-2.0, LengthUnit.FEET);

        Length result =
                length1.add(length2, LengthUnit.INCHES);

        assertEquals(
                new Length(36.0, LengthUnit.INCHES),
                result);
    }

    @Test
    void testAddition_ExplicitTargetUnit_NullTargetUnit() {

        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        assertThrows(
                IllegalArgumentException.class,
                () -> length1.add(length2, null));
    }
}