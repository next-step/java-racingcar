package step4.number;

public class Number {

    private static final int MIN_THRESHOLD = 0;
    private static final int MAX_THRESHOLD = 9;

    private final int value;

    public Number(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_THRESHOLD)
            throw new IllegalArgumentException("number must be bigger than zero");

        if (value > MAX_THRESHOLD)
            throw new IllegalArgumentException("number must be less than ten");
    }

    public int getValue() {
        return value;
    }
}
