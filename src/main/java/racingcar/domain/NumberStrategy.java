package racingcar.domain;

import java.util.Random;

public class NumberStrategy implements Strategy {
    private static final int INCREASE_STANDARD_NUMBER = 4;

    private Random random = new Random();
    private int randomValue = 0;

    @Override
    public boolean isMovable() {
        if (INCREASE_STANDARD_NUMBER <= createRandomValue()) {
            return true;
        }
        return false;
    }

    private int createRandomValue() {
        randomValue =  random.nextInt(10);
        return randomValue;
    }

    public int getRandomValue() {
        return randomValue;
    }
}
