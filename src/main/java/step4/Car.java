package step4;

import java.util.Random;

public class Car {

    private static final int MOVABLE_MINIMUM_VALUE = 4;
    private static final int RANDOM_VALUE_RANGE = 10;
    private static final Random RANDOM_GENERATOR = new Random();

    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void tryRound() {
        if (isMovable()) {
            move();
        }
    }

    public boolean isMovable() {
        return (MOVABLE_MINIMUM_VALUE <= RANDOM_GENERATOR.nextInt(RANDOM_VALUE_RANGE));
    }

    public void move() {
        distance++;
    }
}
