package study.step5.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy{
    private static final int RANDOM_RANGE = 10;
    private static final int MOVE_RESTRICT = 4;

    @Override
    public boolean movable() {
        return getGenerateRandomNumber() >= MOVE_RESTRICT;
    }

    private int getGenerateRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_RANGE);
    }
}
