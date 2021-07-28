package carracing.domain;

public class Position {

    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE_FORMAT = "유효하지 않은 위치 값입니다. value: %d";
    private static final int ADDITION_VALUE = 1;
    private static final int LOWER_LIMIT = 0;

    private final int value;

    private Position(int value) {
        this.value = value;
    }

    public static Position of(int value) {
        validateLowerLimit(value);
        return new Position(value);
    }

    private static void validateLowerLimit(int value) {
        if (value < LOWER_LIMIT) {
            throw new IllegalArgumentException(String.format(OUT_OF_RANGE_EXCEPTION_MESSAGE_FORMAT, value));
        }
    }

    public Position next() {
        return Position.of(value + ADDITION_VALUE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position other = (Position) o;
        return this.value == other.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    public int getValue() {
        return value;
    }
}
