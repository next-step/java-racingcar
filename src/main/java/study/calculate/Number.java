package study.calculate;

public class Number {

    private static final String ZERO_DIVIDE_EXCEPTION_MESSAGE = "denominator can't be a zero";
    public static final String IS_NOT_A_NUMERIC_STRING = " is not a numeric string.";

    private final int value;

    public Number(int value) {
        this.value = value;
    }

    public Number(String value) {
        try {
            this.value = Integer.parseInt(value);
        } catch (Exception e) {
            throw new RuntimeException(value + IS_NOT_A_NUMERIC_STRING);
        }
    }

    public int value() {
        return this.value;
    }

    public Number plus(Number number) {
        return new Number(this.value + number.value());
    }

    public Number minus(Number number) {
        return new Number(this.value - number.value());
    }

    public Number times(Number number) {
        return new Number(this.value * number.value());
    }

    public Number divide(Number number) {
        if (number.value() == 0) {
            throw new RuntimeException(ZERO_DIVIDE_EXCEPTION_MESSAGE);
        }
        return new Number(this.value / number.value());
    }
}
