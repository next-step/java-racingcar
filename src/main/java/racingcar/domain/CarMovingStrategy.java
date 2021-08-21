package racingcar.domain;

import java.util.Random;

public class CarMovingStrategy implements MovingStrategy {
    private static final Random random = new Random();
    private static final int MAX_RANDOM_NUM = 10;
    private static final int CRITERION_FOR_MOVING = 4;

    @Override
    public boolean isMovable() {
        return random.nextInt(MAX_RANDOM_NUM) >= CRITERION_FOR_MOVING;
    }
}
