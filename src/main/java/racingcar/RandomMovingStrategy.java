package racingcar;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    public static int RANDOM_BOUND = 10;
    public static int LEAST_MOVABLE_NUM = 4;

    @Override
    public boolean isMovable() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND) >= LEAST_MOVABLE_NUM;
    }
}
