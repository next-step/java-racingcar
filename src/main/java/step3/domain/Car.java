package step3.domain;

import java.util.Random;

public class Car {
    public static final int MIN_MOVEMENT_THRESHOLD = 4;
    public static final String GO = "-";
    public static final String STOP = "";

    private final Random random = new Random();

    private String position = "";

    public void move() {
        updatePosition(getMovementStatus(generateRandomNumber()));
    }

    public String getPosition() {
        return position;
    }

    void updatePosition(String movementStatus) {
        if (movementStatus.equals(GO)) {
            position += movementStatus;
        }
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

