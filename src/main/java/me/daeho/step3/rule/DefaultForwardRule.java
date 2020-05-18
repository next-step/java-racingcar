package me.daeho.step3.rule;

import java.util.Random;

public class DefaultForwardRule implements ForwardRule {
    private static final Random GENERATOR = new Random();
    private static final int FORWARD_CRITERIA_VALUE = 4;
    private static final int RANDOM_BOUND = 10;

    @Override
    public boolean isForward() {
        return GENERATOR.nextInt(RANDOM_BOUND) >= FORWARD_CRITERIA_VALUE;
    }
}
