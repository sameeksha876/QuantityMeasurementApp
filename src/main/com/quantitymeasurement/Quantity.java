package com.quantitymeasurement;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (Double.isNaN(value) || Double.isInfinite(value))
            throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public Quantity<U> convertTo(U targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue =
                unit.convertToBaseUnit(value);

        double convertedValue =
                targetUnit.convertFromBaseUnit(baseValue);

        convertedValue =
                Math.round(convertedValue * 100.0) / 100.0;

        return new Quantity<>(convertedValue, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {

        if (other == null)
            throw new IllegalArgumentException("Quantity cannot be null");

        double totalBaseValue =
                unit.convertToBaseUnit(value)
                        + other.unit.convertToBaseUnit(other.value);

        double convertedValue =
                unit.convertFromBaseUnit(totalBaseValue);

        convertedValue =
                Math.round(convertedValue * 100.0) / 100.0;

        return new Quantity<>(convertedValue, unit);
    }

    public Quantity<U> add(Quantity<U> other,
                           U targetUnit) {

        if (other == null)
            throw new IllegalArgumentException("Quantity cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double totalBaseValue =
                unit.convertToBaseUnit(value)
                        + other.unit.convertToBaseUnit(other.value);

        double convertedValue =
                targetUnit.convertFromBaseUnit(totalBaseValue);

        convertedValue =
                Math.round(convertedValue * 100.0) / 100.0;

        return new Quantity<>(convertedValue, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Quantity<?> quantity = (Quantity<?>) obj;

        double thisBase =
                unit.convertToBaseUnit(value);

        double otherBase =
                quantity.unit.convertToBaseUnit(quantity.value);

        return Double.compare(thisBase, otherBase) == 0;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}