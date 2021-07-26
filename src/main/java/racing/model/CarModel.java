package racing.model;

public class CarModel {
    private static final int moveValue = 1;
    private int distance;

    public CarModel() {
        this.distance = 0;
    }

    public void go() {
        this.distance = this.distance + moveValue;
    }

    public int totalDistance() {
        return this.distance;
    }
}
