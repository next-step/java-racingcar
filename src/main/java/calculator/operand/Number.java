package calculator.operand;

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

    public Number plus(final Number otherNumber) {
        return new Number(this.value + otherNumber.value);
    }

    public Number minus(final Number otherNumber) {
        return new Number(this.value - otherNumber.value);
    }

    public Number multiple(final Number otherNumber) {
        return new Number(this.value * otherNumber.value);
    }

    public Number divide(final Number otherNumber) {
        if (this.value == 0 || otherNumber.value == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return new Number(this.value / otherNumber.value);
    }

    public int getValue() {
        return this.value;
    }


}
