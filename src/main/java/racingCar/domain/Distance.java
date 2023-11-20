package racingCar.domain;

public class Distance {
    private int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public static Distance init() {
        return new Distance(0);
    }

    public void increase() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }
}
