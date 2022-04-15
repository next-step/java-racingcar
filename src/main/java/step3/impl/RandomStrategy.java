package step3.impl;

import step3.model.TryStrategy;

import java.util.Random;

public class RandomStrategy implements TryStrategy {

    private static final Random RANDOM = new Random();
    private static final int MAX = 10;
    private static final int THRESHOLD = 4;

    @Override
    public boolean canGoForward() {
        return generate() >= THRESHOLD;
    }

    private int generate() {
        return RANDOM.nextInt(MAX);
    }
}
