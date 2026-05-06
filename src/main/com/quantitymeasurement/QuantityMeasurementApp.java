package com.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<LengthUnit> feet =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(24.0, LengthUnit.INCHES);

        System.out.println(
                feet.subtract(inches));

        System.out.println(
                feet.divide(
                        new Quantity<>(2.0,
                                LengthUnit.FEET)));

        Quantity<WeightUnit> kilogram =
                new Quantity<>(5.0,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(1000.0,
                        WeightUnit.GRAM);

        System.out.println(
                kilogram.subtract(gram));

        Quantity<VolumeUnit> litre =
                new Quantity<>(5.0,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> millilitre =
                new Quantity<>(500.0,
                        VolumeUnit.MILLILITRE);

        System.out.println(
                litre.subtract(millilitre));
    }
}