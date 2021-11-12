package study.calculate;

public class Number {

    private final int value;

    public Number(int value) {
        this.value = value;
    }

    public Number(String value) {
        this.value = Integer.parseInt(value);
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
        return new Number(this.value / number.value());
    }
}
