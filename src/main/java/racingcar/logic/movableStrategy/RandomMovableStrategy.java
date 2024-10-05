package racingcar.logic.movableStrategy;

import java.util.Random;

public class RandomMovableStrategy implements MovableStrategy{
    private static final Random RANDOM = new Random();
    private static final int RACE_DECISION_NUMBER = 4;
    private static final int RANDOM_MAX_BOUND = 10;

    @Override
    public boolean isMove() {
        return RANDOM.nextInt(RANDOM_MAX_BOUND) >= RACE_DECISION_NUMBER;
    }
}
