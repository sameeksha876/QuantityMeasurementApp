package com.quantitymeasurement;

public class QuantityMeasurementApp {

    public static class Length {

        private final double value;
        private final LengthUnit unit;

        public enum LengthUnit {

            FEET(12.0),
            INCHES(1.0),
            YARDS(36.0),
            CENTIMETERS(0.393701);

            private final double conversionFactor;

            LengthUnit(double conversionFactor) {
                this.conversionFactor = conversionFactor;
            }

            public double getConversionFactor() {
                return conversionFactor;
            }
        }

        public Length(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        private double convertToBaseUnit() {
            return value * unit.getConversionFactor();
        }

        public double convertTo(LengthUnit targetUnit) {

            if (targetUnit == null)
                throw new IllegalArgumentException("Target unit cannot be null");

            double baseValue = convertToBaseUnit();

            return baseValue / targetUnit.getConversionFactor();
        }

        public Length add(Length other) {

            if (other == null)
                throw new IllegalArgumentException("Length cannot be null");

            double totalBaseValue =
                    this.convertToBaseUnit()
                            + other.convertToBaseUnit();

            double convertedValue =
                    totalBaseValue / this.unit.getConversionFactor();

            return new Length(convertedValue, this.unit);
        }

        public Length add(Length other, LengthUnit targetUnit) {

            if (other == null)
                throw new IllegalArgumentException("Length cannot be null");

            if (targetUnit == null)
                throw new IllegalArgumentException("Target unit cannot be null");

            double totalBaseValue =
                    this.convertToBaseUnit()
                            + other.convertToBaseUnit();

            double convertedValue =
                    totalBaseValue / targetUnit.getConversionFactor();

            convertedValue =
                    Math.round(convertedValue * 100.0) / 100.0;

            return new Length(convertedValue, targetUnit);
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            Length length = (Length) obj;

            return Double.compare(
                    this.convertToBaseUnit(),
                    length.convertToBaseUnit()) == 0;
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }
}