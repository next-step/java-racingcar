package study.calculate;

public class IntNumber {

    private final int value;

    public IntNumber(int value) {
        this.value = value;
    }

    public IntNumber(String value) {
        this.value = Integer.parseInt(value);
    }

    public int value() {
        return this.value;
    }

    public IntNumber plus(IntNumber number) {
        return new IntNumber(this.value + number.value());
    }

    public IntNumber minus(IntNumber number) {
        return new IntNumber(this.value - number.value());
    }

    public IntNumber times(IntNumber number) {
        return new IntNumber(this.value * number.value());
    }

    public IntNumber divide(IntNumber number) {
        return new IntNumber(this.value / number.value());
    }
}
