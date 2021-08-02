package racingcar.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private final int RANDOM_NUMBER_MAX = 10;
    private final int MORE_THEN_CONDITION_NUMBER = 4;
    private final Random RANDOM = new Random();

    public RandomMoveStrategy() {
    }

    @Override
    public boolean isMoveAble() {
        return pickRandomNumber() >= MORE_THEN_CONDITION_NUMBER;
    }

    public int pickRandomNumber() {
        return RANDOM.nextInt(RANDOM_NUMBER_MAX);
    }
}