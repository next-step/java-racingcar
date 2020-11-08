package step3;

import java.util.Random;

public class Car {

    private static final int MIN_MOVING_CONDITION = 4;
    private static final int POSITION_MOVE = 1;

    private int currentPosition = 0;

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void move(int randomValue) {
        if(checkRandom(randomValue)) {
            this.currentPosition += POSITION_MOVE;
        }
    }

    private boolean checkRandom(int randomValue) {
        return randomValue >= MIN_MOVING_CONDITION;
    }
}
