package racingcar.domain;

import java.util.Random;

public class Car {
    private static final int MIN_MOVEMENT_THRESHOLD = 4;
    private static final int GO = 1;
    private static final int STOP = 0;

    private final Random random = new Random();

    private int position = 0;

    public void move() {
        if (getMovementStatus(generateRandomNumber()) == GO) {
            position += GO;
        }
    }

    public int getPosition() {
        return position;
    }

    private int getMovementStatus(int randomNumber) {
        if (randomNumber >= MIN_MOVEMENT_THRESHOLD) {
            return GO;
        }

        return STOP;
    }

    protected int generateRandomNumber() {
        return random.nextInt(10);
    }
}

