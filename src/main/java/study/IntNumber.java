package study;

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
}
