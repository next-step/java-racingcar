package racingcar.model;

import java.util.Random;

public class ForwardDecider {
    private static final int TOTAL_BOUND = 10;
    private static final int SUCCESS_BOUND = 4;
    private final Random random;

    public ForwardDecider() {
        this.random = new Random();
    }

    public ForwardDecider(long seed) {
        this.random = new Random(seed);
    }

    public boolean decide() {
        return random.nextInt(TOTAL_BOUND) >= SUCCESS_BOUND;
    }
}
