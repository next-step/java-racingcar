package calculator.operand;

public final class Number {
    private int value;

    private Number(int value) {
        this.value = value;
    }

    public static Number intValueOf(final String text) {
        return new Number(Integer.parseInt(text));
    }

    public Number plus(final Number otherNumber) {
        return new Number(this.value + otherNumber.value);
    }

    public int getValue() {
        return this.value;
    }
}
