package racingcar;

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
}
