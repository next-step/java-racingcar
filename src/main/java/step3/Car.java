package step3;

import java.util.Random;

public class Car {

    private final Random randomGenerator;
    private int distance;

    public Car() {
        randomGenerator = new Random();
        distance = 0;
    }

    public void tryOneRound() {
        if (isMovable()) {
            move();
        }
    }

    public void move() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isMovable() {
        return (4 <= this.randomGenerator.nextInt(10));
    }
}
