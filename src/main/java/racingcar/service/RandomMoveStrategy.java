package racingcar.service;

import java.util.Random;

public class RandomMoveStrategy implements NumberStrategy{
    private static final int RANDOM_MAX = 9;
    private static final int GO_MAX = 9;
    private static final int GO_MIN = 4;
    private static Random random = new Random();

    public RandomMoveStrategy() {
        int randomNumber = getRandomNumber();
    }

    private int getRandomNumber() {
        return random.nextInt(RANDOM_MAX);
    }

    @Override
    public boolean isMovable() {
        int randomNumber = getRandomNumber();
        return randomNumber >= GO_MIN && randomNumber <= GO_MAX;
    }
}
