package javaracingcar;

import java.util.Random;

public class JavaRacingCar {

    private Random random;

    private static final int RANDOM_VALUE_RANGE = 10;
    private static final int MIN_MOVING_RANGE = 4;
    private static final int MAX_MOVING_RANGE = 9;

    public JavaRacingCar() {
        random = new Random();
    }

    protected int random() {
        int randomValue = random.nextInt(RANDOM_VALUE_RANGE);
        return randomValue;
    }

    protected boolean isMove(int randomValue) {

        if (MIN_MOVING_RANGE <= randomValue && randomValue <= MAX_MOVING_RANGE) {
            return true;
        }

        return false;
    }
}
