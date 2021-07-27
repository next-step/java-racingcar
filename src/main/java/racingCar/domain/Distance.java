package racingCar.domain;

public class Distance {

    private final int distance;
    private static final int INITIAL_POSITION = 0;
    private static final int ADD = 1;

    public Distance() {
        this.distance = INITIAL_POSITION;
    }

    public Distance(int distance) {
        this.distance = distance;
    }

    public Distance addDistance() {
        return new Distance(this.distance + ADD);
    }

    public int getDistance() {
        return this.distance;
    }

    public boolean isSameDistance(int distance) {
        return this.distance == distance;
    }

}
