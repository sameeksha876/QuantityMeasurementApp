package com.quantitymeasurement;

public class QuantityMeasurementApp {

    public static class Length {

        private final double value;
        private final LengthUnit unit;

        public enum LengthUnit {

            FEET(12.0),
            INCHES(1.0);

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
    }
}