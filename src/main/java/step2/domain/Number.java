package step2.domain;

public class Number {
    private int value;

    private Number(int value) {
        this.value = value;
    }

    private Number(String value) {
        this.value = Integer.parseInt(value);
    }

    public static Number of(int value) {
        return new Number(value);
    }

    public static Number of(String value) {
        return new Number(value);
    }

    public int plus(Number operand) {
        return (this.value + operand.value);
    }

    public int subtract(Number operand) {
        return (this.value - operand.value);
    }

    public int multiply(Number operand) {
        return (this.value * operand.value);
    }

    public int division(Number operand) {
        return (this.value / operand.value);
    }
}
