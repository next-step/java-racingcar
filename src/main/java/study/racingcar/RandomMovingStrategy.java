package study.racingcar;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    public static final int MAX_RANDOM_NUM = 10;
    private static final int MAX_BOUND = 4;

    @Override
    public boolean movable() {
        return getRandomNumber() >= MAX_BOUND;
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_NUM);
    }
}
