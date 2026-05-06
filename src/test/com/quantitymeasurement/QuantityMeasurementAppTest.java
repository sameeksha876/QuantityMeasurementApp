package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.quantitymeasurement.QuantityMeasurementApp.Length;
import com.quantitymeasurement.LengthUnit;

import com.quantitymeasurement.WeightUnit;
import com.quantitymeasurement.QuantityMeasurementApp.QuantityWeight;

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

    @Test
    void testWeightEquality_KgToGram() {

        QuantityWeight kg =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight gram =
                new QuantityWeight(1000.0, WeightUnit.GRAM);

        assertEquals(kg, gram);
    }

    @Test
    void testWeightEquality_KgToPound() {

        QuantityWeight kg =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight pound =
                new QuantityWeight(2.20462, WeightUnit.POUND);

        assertEquals(kg.convertTo(WeightUnit.POUND),
                pound.convertTo(WeightUnit.POUND),
                0.01);
    }

    @Test
    void testWeightConversion_KgToGram() {

        QuantityWeight kg =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        assertEquals(1000.0,
                kg.convertTo(WeightUnit.GRAM),
                0.01);
    }

    @Test
    void testWeightConversion_GramToKg() {

        QuantityWeight gram =
                new QuantityWeight(5000.0, WeightUnit.GRAM);

        assertEquals(5.0,
                gram.convertTo(WeightUnit.KILOGRAM),
                0.01);
    }

    @Test
    void testWeightAddition_SameUnit() {

        QuantityWeight weight1 =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight weight2 =
                new QuantityWeight(2.0, WeightUnit.KILOGRAM);

        QuantityWeight result =
                weight1.add(weight2);

        assertEquals(
                new QuantityWeight(3.0, WeightUnit.KILOGRAM),
                result);
    }

    @Test
    void testWeightAddition_DifferentUnits() {

        QuantityWeight kg =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight gram =
                new QuantityWeight(1000.0, WeightUnit.GRAM);

        QuantityWeight result =
                kg.add(gram);

        assertEquals(
                new QuantityWeight(2.0, WeightUnit.KILOGRAM),
                result);
    }

    @Test
    void testWeightAddition_WithTargetUnit() {

        QuantityWeight pound =
                new QuantityWeight(1.0, WeightUnit.POUND);

        QuantityWeight gram =
                new QuantityWeight(453.592, WeightUnit.GRAM);

        QuantityWeight result =
                pound.add(gram, WeightUnit.POUND);

        assertEquals(
                new QuantityWeight(2.0, WeightUnit.POUND),
                result);
    }

    @Test
    void testWeightAndLength_AreNotEqual() {

        QuantityWeight weight =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        Length length =
                new Length(1.0, LengthUnit.FEET);

        assertNotEquals(weight, length);
    }
}

