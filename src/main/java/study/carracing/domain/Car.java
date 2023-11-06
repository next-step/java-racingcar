package study.carracing.domain;

import study.carracing.util.RandomGenerator;

public class Car {

    private static final int MIN_MOVE_VALUE = 4;
    private static final int INITIAL_POSITION = 1;

    private int position;
    private RandomGenerator randomGenerator;

    public Car(RandomGenerator randomGenerator) {
        this.position = INITIAL_POSITION;
        this.randomGenerator = randomGenerator;
    }

    public void move() {
        go(randomGenerator.nextInt(10));
    }

    public void go(int randomValue) {
        if (randomValue >= MIN_MOVE_VALUE) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }
}
