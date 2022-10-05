package step3.domains;

import step3.utils.RandomSingleton;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int MIN_NUM_TO_MOVE = 4;
    private static final int MAX_BOUND = 10;

    @Override
    public boolean movable() {
        return getRandomNumber() >= MIN_NUM_TO_MOVE;
    }

    private int getRandomNumber() {
        return RandomSingleton.INSTANCE.getInstance().nextInt(MAX_BOUND);
    }
}
