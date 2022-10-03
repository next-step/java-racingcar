package racinggame.domain.strategy;

import racinggame.util.RandomUtils;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int CAN_MOVE_MIN_NUMBER = 4;
    public static final int MAX_RANDOM_NUMBER = 10;

    @Override
    public boolean movable() {
        return getRandomNumber() >= CAN_MOVE_MIN_NUMBER;
    }

    protected int getRandomNumber() {
        return RandomUtils.randomNumber(MAX_RANDOM_NUMBER);
    }
}
