package racing.domain;

import racing.domain.GameRule;

import java.util.Random;

public class RandomGameRule implements GameRule {

    private static final int RANDOM_INT_MAX = 10;
    private static final int POSSIBLE_INT = 4;

    public int makeRandomInt() {
        Random random = new Random();
        return random.nextInt(RANDOM_INT_MAX);
    }

    public int getPossibleInt() {
        return (POSSIBLE_INT <= makeRandomInt()) ? 1 : 0;
    }
}
