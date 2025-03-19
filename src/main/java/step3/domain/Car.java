package step3.domain;

import java.util.Random;

public class Car {
    public static final int MIN_MOVEMENT_THRESHOLD = 4;
    public static final int GO = 1;
    public static final int STOP = 0;

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

