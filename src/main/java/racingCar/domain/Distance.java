package racingCar.domain;

public class Distance {

    private final int distance;

    public Distance() {
        this.distance = 0;
    }

    public Distance(int distance) {
        this.distance = distance;
    }

    public Distance addDistance() {
        return new Distance(this.distance + 1);
    }

    public int getDistance() {
        return this.distance;
    }

}
