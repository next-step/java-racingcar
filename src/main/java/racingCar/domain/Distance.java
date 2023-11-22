package racingCar.domain;

public class Distance{
    public static final int DEFAULT_DISTANCE = 0;
    private int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public static Distance init() {
        return new Distance(DEFAULT_DISTANCE);
    }

    public void increase() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isSameDistance(int otherDistance) {
        return distance == otherDistance;
    }
}
