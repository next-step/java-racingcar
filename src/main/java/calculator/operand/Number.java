package calculator.operand;

import calculator.operator.Operator;

public final class Number {
    private int value;

    private Number(int value) {
        this.value = value;
    }

    public static Number intValueOf(final String text) {
        return new Number(Integer.parseInt(text));
    }

    public static boolean isNumber(final String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Number calculate(final Operator operator, final Number otherNumber) {
        return new Number(operator.operate(this.value, otherNumber.value));
    }

    public int getValue() {
        return this.value;
    }
}
