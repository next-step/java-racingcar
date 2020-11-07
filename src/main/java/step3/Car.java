package step3;

import java.util.Random;

public class Car {

    private static final int MIN_MOVING_CONDITION = 4;
    private static final int MAX_MOVING_BOUNDARY = 10;
    private static final int POSITION_MOVE = 1;

    private static final Random random = new Random();

    private int currentPosition = 0;

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void move(int randomValue) {
        if(checkRandom(randomValue)) {
            this.currentPosition += POSITION_MOVE;
        }
    }

    public int makeRandomValue() {
        return random.nextInt(MAX_MOVING_BOUNDARY);
    }

    private boolean checkRandom(int randomValue) {
        return randomValue >= MIN_MOVING_CONDITION;
    }
}
