package me.namuhuchutong.step4;

import java.util.Random;

public class RandomRacingRule implements RacingRule {

    private static final int RANDOM_BOUND = 10;
    private static final int MOVE_CONDITION = 3;
    private static final Random RANDOM = new Random();

    @Override
    public boolean isSatisfiedRule() {
        return MOVE_CONDITION < RANDOM.nextInt(RANDOM_BOUND);
    }
}
