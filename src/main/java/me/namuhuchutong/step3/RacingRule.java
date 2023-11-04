package me.namuhuchutong.step3;

import java.util.Random;

public class RacingRule {

    private final Random random = new Random();

    public boolean isSatisfiedRule() {
        return 3 < random.nextInt(10);
    }
}
