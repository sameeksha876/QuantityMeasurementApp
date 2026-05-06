package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.quantitymeasurement.QuantityMeasurementApp.Length;
import com.quantitymeasurement.QuantityMeasurementApp.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {

        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(2.0, LengthUnit.FEET);

        Length result = length1.add(length2);

        assertEquals(
                new Length(3.0, LengthUnit.FEET),
                result);
    }

    @Test
    void testAddition_SameUnit_InchPlusInch() {

        Length length1 = new Length(6.0, LengthUnit.INCHES);
        Length length2 = new Length(6.0, LengthUnit.INCHES);

        Length result = length1.add(length2);

        assertEquals(
                new Length(12.0, LengthUnit.INCHES),
                result);
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {

        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length result = length1.add(length2);

        assertEquals(
                new Length(2.0, LengthUnit.FEET),
                result);
    }

    @Test
    void testAddition_CrossUnit_InchesPlusFeet() {

        Length length1 = new Length(12.0, LengthUnit.INCHES);
        Length length2 = new Length(1.0, LengthUnit.FEET);

        Length result = length1.add(length2);

        assertEquals(
                new Length(24.0, LengthUnit.INCHES),
                result);
    }

    @Test
    void testAddition_CrossUnit_YardPlusFeet() {

        Length length1 = new Length(1.0, LengthUnit.YARDS);
        Length length2 = new Length(3.0, LengthUnit.FEET);

        Length result = length1.add(length2);

        assertEquals(
                new Length(2.0, LengthUnit.YARDS),
                result);
    }

    @Test
    void testAddition_WithZero() {

        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length zero = new Length(0.0, LengthUnit.INCHES);

        Length result = length1.add(zero);

        assertEquals(
                new Length(5.0, LengthUnit.FEET),
                result);
    }

    @Test
    void testAddition_NegativeValues() {

        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length length2 = new Length(-2.0, LengthUnit.FEET);

        Length result = length1.add(length2);

        assertEquals(
                new Length(3.0, LengthUnit.FEET),
                result);
    }

    @Test
    void testAddition_NullSecondOperand() {

        Length length = new Length(1.0, LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> length.add(null));
    }

    @Test
    void testAddition_LargeValues() {

        Length length1 = new Length(1000.0, LengthUnit.FEET);
        Length length2 = new Length(500.0, LengthUnit.FEET);

        Length result = length1.add(length2);

        assertEquals(
                new Length(1500.0, LengthUnit.FEET),
                result);
    }

    @Test
    void testAddition_SmallValues() {

        Length length1 = new Length(0.001, LengthUnit.FEET);
        Length length2 = new Length(0.002, LengthUnit.FEET);

        Length result = length1.add(length2);

        assertEquals(
                new Length(0.003, LengthUnit.FEET),
                result);
    }
}