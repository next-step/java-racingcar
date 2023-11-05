package me.namuhuchutong.step3;

import java.util.Random;

public class RandomRacingRule extends DefaultRacingRule {

    public static final int BOUND = 10;

    private final Random random = new Random();

    @Override
    public boolean isSatisfiedRule() {
        return 3 < random.nextInt(BOUND);
    }
}
