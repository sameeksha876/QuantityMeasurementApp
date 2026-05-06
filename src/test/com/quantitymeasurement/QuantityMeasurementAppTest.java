package com.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.quantitymeasurement.Quantity;
import com.quantitymeasurement.LengthUnit;
import com.quantitymeasurement.WeightUnit;
import com.quantitymeasurement.VolumeUnit;

public class QuantityMeasurementAppTest {

    @Test
    void testLengthEquality() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        assertEquals(feet, inches);
    }

    @Test
    void testLengthConversion() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result =
                feet.convertTo(LengthUnit.INCHES);

        assertEquals(
                new Quantity<>(12.0, LengthUnit.INCHES),
                result);
    }

    @Test
    void testLengthAddition() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                feet.add(inches);

        assertEquals(
                new Quantity<>(2.0, LengthUnit.FEET),
                result);
    }

    @Test
    void testWeightEquality() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        assertEquals(kilogram, gram);
    }

    @Test
    void testWeightConversion() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result =
                kilogram.convertTo(WeightUnit.GRAM);

        assertEquals(
                new Quantity<>(1000.0, WeightUnit.GRAM),
                result);
    }

    @Test
    void testWeightAddition() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result =
                kilogram.add(gram);

        assertEquals(
                new Quantity<>(2.0, WeightUnit.KILOGRAM),
                result);
    }

    @Test
    void testCrossCategory_NotEqual() {

        Quantity<LengthUnit> length =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<WeightUnit> weight =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertNotEquals(length, weight);
    }

    @Test
    void testVolumeEquality_LitreToLitre() {

        Quantity<VolumeUnit> litre1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> litre2 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        assertEquals(litre1, litre2);
    }

    @Test
    void testVolumeEquality_LitreToMillilitre() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> millilitre =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertEquals(litre, millilitre);
    }

    @Test
    void testVolumeConversion_LitreToMillilitre() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                litre.convertTo(VolumeUnit.MILLILITRE);

        assertEquals(
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE),
                result);
    }

    @Test
    void testVolumeConversion_MillilitreToLitre() {

        Quantity<VolumeUnit> millilitre =
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                millilitre.convertTo(VolumeUnit.LITRE);

        assertEquals(
                new Quantity<>(1.0,
                        VolumeUnit.LITRE),
                result);
    }

    @Test
    void testVolumeEquality_LitreToGallon() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> gallon =
                new Quantity<>(0.264172, VolumeUnit.GALLON);

        assertEquals(
                litre.convertTo(VolumeUnit.GALLON),
                gallon.convertTo(VolumeUnit.GALLON));
    }

    @Test
    void testVolumeAddition_SameUnit() {

        Quantity<VolumeUnit> litre1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> litre2 =
                new Quantity<>(2.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                litre1.add(litre2);

        assertEquals(
                new Quantity<>(3.0, VolumeUnit.LITRE),
                result);
    }

    @Test
    void testVolumeAddition_CrossUnit() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> millilitre =
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                litre.add(millilitre);

        assertEquals(
                new Quantity<>(2.0, VolumeUnit.LITRE),
                result);
    }

    @Test
    void testVolumeAddition_ExplicitTargetUnit() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> millilitre =
                new Quantity<>(1000.0,
                        VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                litre.add(millilitre,
                        VolumeUnit.MILLILITRE);

        assertEquals(
                new Quantity<>(2000.0,
                        VolumeUnit.MILLILITRE),
                result);
    }

    @Test
    void testVolumeAndLength_AreNotEqual() {

        Quantity<VolumeUnit> volume =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<LengthUnit> length =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertNotEquals(volume, length);
    }

    @Test
    void testVolumeAndWeight_AreNotEqual() {

        Quantity<VolumeUnit> volume =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<WeightUnit> weight =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertNotEquals(volume, weight);
    }

    @Test
    void testSubtraction_SameUnit() {

        Quantity<LengthUnit> feet1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> feet2 =
                new Quantity<>(5.0, LengthUnit.FEET);

        assertEquals(
                new Quantity<>(5.0, LengthUnit.FEET),
                feet1.subtract(feet2));
    }

    @Test
    void testSubtraction_CrossUnit() {

        Quantity<LengthUnit> inches =
                new Quantity<>(120.0, LengthUnit.INCHES);

        Quantity<LengthUnit> feet =
                new Quantity<>(5.0, LengthUnit.FEET);

        assertEquals(
                new Quantity<>(60.0, LengthUnit.INCHES),
                inches.subtract(feet));
    }

    @Test
    void testSubtraction_ExplicitTargetUnit() {

        Quantity<LengthUnit> feet1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> feet2 =
                new Quantity<>(6.0, LengthUnit.FEET);

        assertEquals(
                new Quantity<>(48.0, LengthUnit.INCHES),
                feet1.subtract(feet2,
                        LengthUnit.INCHES));
    }

    @Test
    void testSubtraction_ResultingNegative() {

        Quantity<LengthUnit> feet1 =
                new Quantity<>(5.0, LengthUnit.FEET);

        Quantity<LengthUnit> feet2 =
                new Quantity<>(10.0, LengthUnit.FEET);

        assertEquals(
                new Quantity<>(-5.0, LengthUnit.FEET),
                feet1.subtract(feet2));
    }

    @Test
    void testSubtraction_ResultingZero() {

        Quantity<LengthUnit> feet1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(120.0, LengthUnit.INCHES);

        assertEquals(
                new Quantity<>(0.0, LengthUnit.FEET),
                feet1.subtract(inches));
    }

    @Test
    void testDivision_SameUnit() {

        Quantity<LengthUnit> feet1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> feet2 =
                new Quantity<>(2.0, LengthUnit.FEET);

        assertEquals(
                5.0,
                feet1.divide(feet2));
    }

    @Test
    void testDivision_CrossUnit() {

        Quantity<LengthUnit> inches =
                new Quantity<>(24.0, LengthUnit.INCHES);

        Quantity<LengthUnit> feet =
                new Quantity<>(2.0, LengthUnit.FEET);

        assertEquals(
                1.0,
                inches.divide(feet));
    }

    @Test
    void testDivision_ResultLessThanOne() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(5.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> litres10 =
                new Quantity<>(10.0, VolumeUnit.LITRE);

        assertEquals(
                0.5,
                litre.divide(litres10));
    }

    @Test
    void testDivision_ByZero() {

        Quantity<LengthUnit> feet =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> zero =
                new Quantity<>(0.0, LengthUnit.FEET);

        assertThrows(
                ArithmeticException.class,
                () -> feet.divide(zero));
    }

    @Test
    void testSubtraction_NullOperand() {

        Quantity<LengthUnit> feet =
                new Quantity<>(10.0, LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> feet.subtract(null));
    }

}