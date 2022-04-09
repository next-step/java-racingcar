package racingcar.model;

import java.util.Random;

public class Car {
    public static final int MOVABLE_NUMBER = 4;
    private static final int DEFAULT_POSITION = 1;
    private static final int RANDOM_NUMBER_BOUND = 10;

    private int position;

    public Car() {
        this(DEFAULT_POSITION);
    }

    public Car(int position) {
        this.position = position;
    }

    public void move() {
        move(getRandomNumber());
    }

    public boolean move(int number) {
        if (number >= MOVABLE_NUMBER) {
            this.position++;
            return true;
        }

        return false;
    }

    public int getPosition() {
        return this.position;
    }

    private int getRandomNumber() {
        return new Random().nextInt(RANDOM_NUMBER_BOUND);
    }
}
