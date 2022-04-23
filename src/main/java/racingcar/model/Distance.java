package racingcar.model;

public final class Distance implements Comparable {
    public static final Distance ZERO = new Distance(0);
    public static final Distance ONE = new Distance(1);

    private final int value;

    public Distance(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (isNegative(value)) {
            throw new IllegalArgumentException(String.format("Distance : 음수(%d)는 허용하지 않습니다.", value));
        }
    }

    private boolean isNegative(int value) {
        return value < 0;
    }

    public int value() {
        return value;
    }

    public static Distance add(Distance origin, Distance add) {
        return new Distance(origin.value + add.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Distance) {
            Distance distance = (Distance) obj;
            return this.value == distance.value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(value).hashCode();
    }

    @Override
    public int compareTo(Object obj) {
        if (obj instanceof Distance) {
            Distance distance = (Distance) obj;
            return value - distance.value();
        }
        return 0;
    }
}
