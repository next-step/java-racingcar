package racingcar;

public final class PositiveInteger {
    public static final PositiveInteger ZERO = new PositiveInteger(0);
    public static final PositiveInteger ONE = new PositiveInteger(1);
    private final int value;

    public PositiveInteger(int value) {
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

    public static PositiveInteger add(PositiveInteger origin, PositiveInteger add) {
        return new PositiveInteger(origin.value + add.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PositiveInteger) {
            PositiveInteger positiveInteger = (PositiveInteger) obj;
            return this.value == positiveInteger.value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(value).hashCode();
    }
}
