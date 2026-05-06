package com.quantitymeasurement;

public class QuantityMeasurementApp {

    public static class Length {

        private final double value;
        private final LengthUnit unit;

        public Length(double value, LengthUnit unit) {

            if (unit == null)
                throw new IllegalArgumentException("Unit cannot be null");

            if (Double.isNaN(value) || Double.isInfinite(value))
                throw new IllegalArgumentException("Invalid value");

            this.value = value;
            this.unit = unit;
        }

        private double convertToBaseUnit() {
            return unit.convertToBaseUnit(value);
        }

        public double convertTo(LengthUnit targetUnit) {

            if (targetUnit == null)
                throw new IllegalArgumentException("Target unit cannot be null");

            double baseValue = convertToBaseUnit();

            return targetUnit.convertFromBaseUnit(baseValue);
        }

        public Length add(Length other) {

            if (other == null)
                throw new IllegalArgumentException("Length cannot be null");

            double totalBaseValue =
                    this.convertToBaseUnit()
                            + other.convertToBaseUnit();

            double convertedValue =
                    this.unit.convertFromBaseUnit(totalBaseValue);

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
                    targetUnit.convertFromBaseUnit(totalBaseValue);

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
    }

    public static class QuantityWeight {

        private final double value;
        private final WeightUnit unit;

        public QuantityWeight(double value, WeightUnit unit) {

            if (unit == null)
                throw new IllegalArgumentException("Unit cannot be null");

            if (Double.isNaN(value) || Double.isInfinite(value))
                throw new IllegalArgumentException("Invalid value");

            this.value = value;
            this.unit = unit;
        }

        private double convertToBaseUnit() {
            return unit.convertToBaseUnit(value);
        }

        public double convertTo(WeightUnit targetUnit) {

            if (targetUnit == null)
                throw new IllegalArgumentException("Target unit cannot be null");

            double baseValue = convertToBaseUnit();

            return targetUnit.convertFromBaseUnit(baseValue);
        }

        public QuantityWeight add(QuantityWeight other) {

            if (other == null)
                throw new IllegalArgumentException("Weight cannot be null");

            double totalBaseValue =
                    this.convertToBaseUnit()
                            + other.convertToBaseUnit();

            double convertedValue =
                    this.unit.convertFromBaseUnit(totalBaseValue);

            return new QuantityWeight(convertedValue, this.unit);
        }

        public QuantityWeight add(QuantityWeight other,
                                  WeightUnit targetUnit) {

            if (other == null)
                throw new IllegalArgumentException("Weight cannot be null");

            if (targetUnit == null)
                throw new IllegalArgumentException("Target unit cannot be null");

            double totalBaseValue =
                    this.convertToBaseUnit()
                            + other.convertToBaseUnit();

            double convertedValue =
                    targetUnit.convertFromBaseUnit(totalBaseValue);

            convertedValue =
                    Math.round(convertedValue * 100.0) / 100.0;

            return new QuantityWeight(convertedValue, targetUnit);
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            QuantityWeight weight = (QuantityWeight) obj;

            return Double.compare(
                    this.convertToBaseUnit(),
                    weight.convertToBaseUnit()) == 0;
        }
    }
}