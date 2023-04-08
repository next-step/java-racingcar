package racingcar.model;

import java.util.Random;

public class Probability {
    private static final int TOTAL_BOUND = 10;
    private static final int SUCCESS_BOUND = 4;
    private final Random random;

    public Probability() {
        this.random = new Random();
    }

    public Probability(long seed) {
        this.random = new Random(seed);
    }

    public boolean success() {
        return random.nextInt(TOTAL_BOUND) >= SUCCESS_BOUND;
    }
}
