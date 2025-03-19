package step3.domain;

import java.util.Random;

public class Car {
    public static final int MIN_MOVEMENT_THRESHOLD = 4;
    public static final String GO = "-";
    public static final String STOP = "";

    private final Random random = new Random();

    private String position = "";

    public void move() {
        if (getMovementStatus(generateRandomNumber()).equals(GO)) {
            position += GO;
        }
    }

    public String getPosition() {
        return position;
    }

    private String getMovementStatus(int randomNumber) {
        if (randomNumber >= MIN_MOVEMENT_THRESHOLD) {
            return GO;
        }

        return STOP;
    }

    protected int generateRandomNumber() {
        return random.nextInt(10);
    }
}

