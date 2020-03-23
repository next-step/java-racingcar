package racingcar.model;

public final class Car {
    private int distance;

    public Car() {
        this(0);
    }

    public Car(final int distance) {
        this.distance = distance;
    }

    public void move() {
        this.distance++;
    }

    public int getDistance() {
        return distance;
    }
}
