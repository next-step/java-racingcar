package racingcar.domain.movable;

import java.util.Random;

public class RandomMovableStrategy implements MovableStrategy {

    private static final int CONDITION_MOVE_AVAILABLE = 4;
    private static final int DEFAULT_BOUND = 10;

    private static final Random RANDOM = new Random();

    private volatile static RandomMovableStrategy instance;

    public RandomMovableStrategy() {
    }

    public static synchronized RandomMovableStrategy getInstance() {
        if (instance == null) {
            synchronized (RandomMovableStrategy.class) {
                if (instance == null) {
                    instance = new RandomMovableStrategy();
                }
            }
        }
        return instance;
    }

    @Override
    public boolean isMovable() {
        return getRandom() >= CONDITION_MOVE_AVAILABLE;
    }

    private int getRandom() {
        return RANDOM.nextInt(DEFAULT_BOUND);
    }
}
