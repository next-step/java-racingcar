package me.devyonghee.basic;

import java.util.Objects;

final class WholeNumber {

    static final WholeNumber ZERO = new WholeNumber(0);

    private final int number;

    private WholeNumber(String string) {
        this(parseInt(string));
    }

    private WholeNumber(int number) {
        validate(number);
        this.number = number;
    }

    static WholeNumber from(String string) {
        if (isBlank(string)) {
            return ZERO;
        }
        return new WholeNumber(string);
    }

    private static boolean isBlank(String target) {
        return target == null || target.isBlank();
    }

    private static int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("string(%s) must be character in the number format", string), e);
        }
    }

    WholeNumber add(WholeNumber wholeNumber) {
        return new WholeNumber(number + wholeNumber.number);
    }

    int number() {
        return number;
    }

    private void validate(int number) {
        if (isNegative(number)) {
            throw new IllegalArgumentException(String.format("number(%d) must be zero or positive", number));
        }
    }

    private boolean isNegative(int integer) {
        return integer < 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WholeNumber that = (WholeNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "ZeroPositive{" +
                "number=" + number +
                '}';
    }
}
