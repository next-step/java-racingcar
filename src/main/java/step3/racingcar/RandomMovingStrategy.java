package step3.racingcar;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy{

    private static final int RANDOM_NUMBER_RANGE_MAX = 10;
    private static final int RANDOM_NUMBER_LIMIT = 4;
    private static final Random randomNumberGenerator = new Random();

    @Override
    public boolean isMovable() {
        int randomNumber = getRandomNumber();
        return randomNumber >= RANDOM_NUMBER_LIMIT;
    }

    private int getRandomNumber() {
        return randomNumberGenerator.nextInt(RANDOM_NUMBER_RANGE_MAX);
    }
}
