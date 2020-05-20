package study.step3;

import java.util.Random;

public class RandomCarMoveCondition implements CarMoveCondition{
    private final static int RANDOM_NUMBER_LIMIT = 10;
    private final static int MOVE_CONDITION_NUMBER = 4;
    private final static Random random = new Random();

    @Override
    public boolean isCarMoveCondition() {
        return random.nextInt(RANDOM_NUMBER_LIMIT) >= MOVE_CONDITION_NUMBER;
    }
}
