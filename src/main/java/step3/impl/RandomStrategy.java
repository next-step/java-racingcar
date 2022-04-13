package step3.impl;

import step3.model.TryStrategy;
import step3.util.RandomIntegerGeneratorUtil;

public class RandomStrategy implements TryStrategy {

    private static final int THRESHOLD = 4;

    @Override
    public boolean canGoForward() {
        return RandomIntegerGeneratorUtil.generate() >= THRESHOLD;
    }
}
