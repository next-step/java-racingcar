package me.namuhuchutong.step3;

import java.util.Random;

public class RandomRacingRule extends DefaultRacingRule {

    public static final int BOUND = 10;
    public static final int MOVE_CONDITION = 3;

    private final Random random = new Random();

    @Override
    public boolean isSatisfiedRule() {
        return MOVE_CONDITION < random.nextInt(BOUND);
    }
}
