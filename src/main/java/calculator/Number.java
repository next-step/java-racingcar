package calculator;

import java.util.Objects;

import static calculator.Validator.dividerValidation;
import static calculator.Validator.numberValidation;

public class Number {
    private final int value;

    public Number(String input) {
        this.value = toInteger(input);
    }

    public Number(int input) {
        this.value = input;
    }

    private int toInteger(String input) {
        numberValidation(input);
        return Integer.parseInt(input);
    }

    public Number plus(Number other) {
        return new Number(this.value + other.value);
    }

    public Number minus(Number other) {
        return new Number(this.value - other.value);
    }

    public Number multiply(Number other) {
        return new Number(this.value * other.value);
    }

    public Number divide(Number other) {
        dividerValidation(other.value);
        return new Number(this.value / other.value);
    }

    public int getValue() {
        return this.value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
