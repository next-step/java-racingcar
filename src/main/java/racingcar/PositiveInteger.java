package racingcar;

public final class PositiveInteger {
    public static final PositiveInteger ZERO = new PositiveInteger(0);
    private final int value;

    PositiveInteger(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(String.format("음수(%d)는 허용하지 않습니다.", value));
        }
    }

    public int value() {
        return value;
    }
}
