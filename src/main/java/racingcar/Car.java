package racingcar;

public class Car {
    private static final int INITIAL_DISTANCE = 1;
    private int distance;

    public Car() {
        this.distance = INITIAL_DISTANCE;
    }

    public Car(int distance) {
        this.distance = distance;
    }

    public void move() {
        distance += 1;
    }

    public int getDistance() {
        return distance;
    }
}
