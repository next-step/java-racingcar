package racingcar.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int MOVE_CONDITION = 4;
    private final Random random;
    public static final int MAX_BOUND = 10;

    private int getRandomNo() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

    public RandomMovingStrategy(Random random) {
        this.random = random;

    }

    @Override
    public boolean movable() {
        return random.nextInt(MAX_BOUND) >= MOVE_CONDITION;
    }
}
