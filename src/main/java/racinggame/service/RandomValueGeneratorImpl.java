package racinggame.service;

import java.util.Random;

public class RandomValueGeneratorImpl implements RandomValueGenerator {

    private static final int LIMIT_NUMBER = 10;

    private static Random random = new Random();

    @Override
    public int getRandomInteger() {
        return random.nextInt(LIMIT_NUMBER);
    }
}
