package racing_refactoring.strategy;

import java.util.Random;

public class RacingStrategyImpl implements RacingStrategy{

    private static final int RACING_MOVE_RULE = 3;
    private static final int RANDOM_NUMBER_MAX = 10;
    private static final Random RANDOM_NUMBER = new Random();

    @Override
    public boolean isMovable() {
        return getRandomNumber() > RACING_MOVE_RULE;
    }

    private int getRandomNumber(){
        return RANDOM_NUMBER.nextInt(RANDOM_NUMBER_MAX);
    }
}
