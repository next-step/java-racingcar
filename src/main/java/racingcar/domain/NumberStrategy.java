package racingcar.domain;

import java.util.Random;

public class NumberStrategy implements Strategy {
    private static final int INCREASE_STANDARD_NUMBER = 4;
    private static final int RANDOM_MAX_VALUE = 10;

    private Random random = new Random();
    private int randomValue = 0;

    @Override
    public boolean isMovable() {
        return INCREASE_STANDARD_NUMBER <= createRandomValue();
    }

    private int createRandomValue() {
        randomValue =  random.nextInt(RANDOM_MAX_VALUE);
        return randomValue;
    }

    public int getRandomValue() {
        return randomValue;
    }
}
