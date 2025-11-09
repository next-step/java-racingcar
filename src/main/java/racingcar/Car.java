package racingcar;

public class Car {
    private static final int DEFAULT_DISTANCE = 0;

    private int distance;

    public Car() {
        this.distance = DEFAULT_DISTANCE;
    }

    public void move(int value) {
        if (value >= 4) distance++;
    }

    public int getDistance() {
        return this.distance;
    }
}
