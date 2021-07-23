package racingCar.domain;

public class Distance {

    private final int distance;
    private final static int ADD = 1;

    public Distance() {
        this.distance = 0;
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

}
