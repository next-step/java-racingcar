package racingcar.domain;

public class Car {
    private static final int RACE_THRESHOLD = 4;

    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return this.name;
    }

    public void move() {
        this.distance++;
    }

    public int getDistance() {
        return this.distance;
    }
}
