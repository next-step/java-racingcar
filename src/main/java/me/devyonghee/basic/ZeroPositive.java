package me.devyonghee.basic;

import java.util.Objects;

final class ZeroPositive {

    static final ZeroPositive ZERO = new ZeroPositive(0);
    private final int number;

    private ZeroPositive(String string) {
        this(parseInt(string));
    }

    private ZeroPositive(int number) {
        validate(number);
        this.number = number;
    }

    static ZeroPositive from(String string) {
        if (isBlank(string)) {
            return ZERO;
        }
        return new ZeroPositive(string);
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

    ZeroPositive add(ZeroPositive zeroPositive) {
        return new ZeroPositive(number + zeroPositive.number);
    }

    int number() {
        return number;
    }

    private void validate(int number) {
        if (isNegative(number)) {
            throw new IllegalStateException(String.format("number(%d) must be zero or positive", number));
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
        ZeroPositive that = (ZeroPositive) o;
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
