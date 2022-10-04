package calculator;

import exception.CustomException;

import java.util.Objects;

import static calculator.Calculator.PLUS;

public class PositiveNumber {

    private final int number;

    private PositiveNumber(int number) {
        this.number = number;
    }

    public static PositiveNumber from(String value) {
        int number = Integer.parseInt(value);
        checkPositive(number);
        return new PositiveNumber(number);
    }

    public static PositiveNumber from(int number) {
        checkPositive(number);
        return new PositiveNumber(number);
    }

    public static PositiveNumber[] from(String[] values) {
        PositiveNumber[] result = new PositiveNumber[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = from(values[i]);
        }
        return result;
    }

    private static void checkPositive(int number) {
        if (number < 0) {
            throw new CustomException(NumberException.NEGATIVE_NUMBER_BAD_REQUEST);
        }
    }

    public PositiveNumber plus(int number) {
        return new PositiveNumber(PLUS.apply(this.number, number));
    }

    public PositiveNumber plus(PositiveNumber number) {
        return new PositiveNumber(PLUS.apply(this.number, number.number));
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber positive = (PositiveNumber) o;
        return number == positive.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
