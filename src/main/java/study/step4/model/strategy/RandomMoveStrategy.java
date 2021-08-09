package study.step4.model.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int CAR_MOVE_CONDITION = 4;
    private static final int RANDOM_NUMBER_BOUND = 10;

    @Override
    public boolean isMoveCondition() {
        return (generatorRandomNumber() >= CAR_MOVE_CONDITION);
    }

    private int generatorRandomNumber() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis() * random.nextInt());
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}