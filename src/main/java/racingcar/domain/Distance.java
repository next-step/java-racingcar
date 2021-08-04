package racingcar.domain;

public class Distance {
    private static final int DEFAULT_DISTANCE = 0;

    private final int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public Distance() {
        this(DEFAULT_DISTANCE);
    }

    public Distance increase() {
        return new Distance(distance + 1);
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int hashCode() {
        return ((Integer) distance).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Distance)) {
            return false;
        }

        return ((Integer) distance).equals(((Distance) obj).distance);
    }
}
