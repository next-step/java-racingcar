package study.step3.model.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int CAR_MOVE_CONDITION = 4;
    private static final int RANDOM_NUMBER_BOUND = 10;

    @Override
    public boolean isMoveCondition() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis() * random.nextInt());

        return random.nextInt(RANDOM_NUMBER_BOUND) >= CAR_MOVE_CONDITION;
    }
}