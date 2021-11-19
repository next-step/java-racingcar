package study.racingcar.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MIN_FORWARD_NUMBER = 4;
    private static final int MAX_RANDOM_NUMBER = 10;

    private Random random = new Random();

    @Override
    public boolean movable() {
        return getRandomNumber() >= MIN_FORWARD_NUMBER;
    }

    private int getRandomNumber() {
        return random.nextInt(MAX_RANDOM_NUMBER);
    }
}
