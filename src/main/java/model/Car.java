package model;

import java.util.Random;

public class Car {
    private final int START_POSITION = 0;
    private int position = START_POSITION;

    public void attemptMove() {
        int RANDOM_BOUND = 10;
        int MINIMUM_NUMBER_TO_MOVE = 4;

        var random = new Random();
        if (random.nextInt(RANDOM_BOUND) >= MINIMUM_NUMBER_TO_MOVE) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
