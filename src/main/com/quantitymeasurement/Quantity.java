package com.quantitymeasurement;

import java.util.function.DoubleBinaryOperator;

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

    private enum ArithmeticOperation {

        ADD((a, b) -> a + b),

        SUBTRACT((a, b) -> a - b),

        DIVIDE((a, b) -> {

            if (b == 0)
                throw new ArithmeticException("Cannot divide by zero");

            return a / b;
        });

        private final DoubleBinaryOperator operation;

        ArithmeticOperation(DoubleBinaryOperator operation) {
            this.operation = operation;
        }

        public double compute(double a, double b) {
            return operation.applyAsDouble(a, b);
        }
    }

    public Quantity<U> convertTo(U targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue =
                unit.convertToBaseUnit(value);

        double convertedValue =
                targetUnit.convertFromBaseUnit(baseValue);

        convertedValue = roundToTwoDecimals(convertedValue);

        return new Quantity<>(convertedValue, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        return add(other, unit);
    }

    public Quantity<U> add(Quantity<U> other,
                           U targetUnit) {

        validateArithmeticOperands(other,
                targetUnit,
                true);

        double result =
                performBaseArithmetic(
                        other,
                        targetUnit,
                        ArithmeticOperation.ADD);

        return new Quantity<>(result, targetUnit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, unit);
    }

    public Quantity<U> subtract(Quantity<U> other,
                                U targetUnit) {

        validateArithmeticOperands(other,
                targetUnit,
                true);

        double result =
                performBaseArithmetic(
                        other,
                        targetUnit,
                        ArithmeticOperation.SUBTRACT);

        return new Quantity<>(result, targetUnit);
    }

    public double divide(Quantity<U> other) {

        validateArithmeticOperands(other,
                null,
                false);

        return performBaseArithmetic(
                other,
                null,
                ArithmeticOperation.DIVIDE);
    }

    private void validateArithmeticOperands(
            Quantity<U> other,
            U targetUnit,
            boolean targetUnitRequired) {

        if (other == null)
            throw new IllegalArgumentException("Quantity cannot be null");

        if (Double.isNaN(other.value)
                || Double.isInfinite(other.value))
            throw new IllegalArgumentException("Invalid value");

        if (!unit.getClass()
                .equals(other.unit.getClass()))
            throw new IllegalArgumentException("Cross-category operation not allowed");

        if (targetUnitRequired && targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");
    }

    private double performBaseArithmetic(
            Quantity<U> other,
            U targetUnit,
            ArithmeticOperation operation) {

        double thisBase =
                unit.convertToBaseUnit(value);

        double otherBase =
                other.unit.convertToBaseUnit(other.value);

        double result =
                operation.compute(thisBase, otherBase);

        if (operation == ArithmeticOperation.DIVIDE)
            return result;

        double convertedResult =
                targetUnit.convertFromBaseUnit(result);

        return roundToTwoDecimals(convertedResult);
    }

    private double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
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