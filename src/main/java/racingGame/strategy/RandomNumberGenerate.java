package racingGame.strategy;

import java.util.Random;

public class RandomNumberGenerate implements NumberGenerateStrategy {

    private static final int RANDOM_NUMBER = 10;
    private final Random random = new Random();

    @Override
    public int NumberGenerate() {
        return random.nextInt(RANDOM_NUMBER);
    }
}