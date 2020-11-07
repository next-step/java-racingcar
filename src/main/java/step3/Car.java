package step3;

import java.util.Random;

public class Car {

    private static final int MOVING_BOUNDARY = 4;

    private static final Random randomValue = new Random();

    private int currentPosition = 0;

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void move() {
        if(checkRandom()) {
            this.currentPosition += 1;
        }
    }

    private boolean checkRandom() {
        return randomValue.nextInt(10) > MOVING_BOUNDARY;
    }
}
