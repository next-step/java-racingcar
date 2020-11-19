package racing.domain;

import java.util.Random;

public class MoveStrategyImpl implements MoveStrategy {

    private static final int FORWARD_CONDITION = 4;
    private static final int RANDOM_RANGE = 10;
    private static final Random random = new Random();

    @Override
    public boolean isMoveAble() {
        return getRandomRange() >= FORWARD_CONDITION;
    }

    public int getRandomRange() {
        return random.nextInt(RANDOM_RANGE);
    }
}
