package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.quantitymeasurement.QuantityMeasurementApp.Length;
import com.quantitymeasurement.QuantityMeasurementApp.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    void testConversion_FeetToInches() {

        Length feet = new Length(1.0, LengthUnit.FEET);

        assertEquals(12.0,
                feet.convertTo(LengthUnit.INCHES));
    }

    @Test
    void testConversion_InchesToFeet() {

        Length inches = new Length(24.0, LengthUnit.INCHES);

        assertEquals(2.0,
                inches.convertTo(LengthUnit.FEET));
    }

    @Test
    void testConversion_YardsToInches() {

        Length yards = new Length(1.0, LengthUnit.YARDS);

        assertEquals(36.0,
                yards.convertTo(LengthUnit.INCHES));
    }

    @Test
    void testConversion_InchesToYards() {

        Length inches = new Length(72.0, LengthUnit.INCHES);

        assertEquals(2.0,
                inches.convertTo(LengthUnit.YARDS));
    }

    @Test
    void testConversion_CentimetersToInches() {

        Length centimeters = new Length(2.54, LengthUnit.CENTIMETERS);

        assertEquals(1.0,
                centimeters.convertTo(LengthUnit.INCHES),
                0.0001);
    }

    @Test
    void testConversion_FeetToYards() {

        Length feet = new Length(6.0, LengthUnit.FEET);

        assertEquals(2.0,
                feet.convertTo(LengthUnit.YARDS));
    }

    @Test
    void testConversion_RoundTrip() {

        Length original = new Length(5.0, LengthUnit.FEET);

        double inches = original.convertTo(LengthUnit.INCHES);

        Length converted = new Length(inches, LengthUnit.INCHES);

        assertEquals(5.0,
                converted.convertTo(LengthUnit.FEET),
                0.0001);
    }

    @Test
    void testConversion_ZeroValue() {

        Length zero = new Length(0.0, LengthUnit.FEET);

        assertEquals(0.0,
                zero.convertTo(LengthUnit.INCHES));
    }

    @Test
    void testConversion_NegativeValue() {

        Length negative = new Length(-1.0, LengthUnit.FEET);

        assertEquals(-12.0,
                negative.convertTo(LengthUnit.INCHES));
    }

    @Test
    void testConversion_InvalidUnit_Throws() {

        Length feet = new Length(1.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class,
                () -> feet.convertTo(null));
    }
}