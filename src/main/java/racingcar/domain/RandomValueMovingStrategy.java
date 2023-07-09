package racingcar.domain;

import java.util.Random;

public class RandomValueMovingStrategy implements MovingStrategy {

    private static final int RANDOM_BOUND = 10;

    @Override
    public boolean isMovable() {
        return getRandomValue() >= Car.MOVE_THRESHOLD;
    }

    private int getRandomValue() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND);
    }
}
