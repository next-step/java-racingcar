package racing.domain;

import java.util.Random;

public class CarMoveStrategy {
    private final Random random;
    private final int RANDOM_BOUND = 10;
    private final int bound;

    public CarMoveStrategy(Random random) {
        this.random = random;
        this.bound = RANDOM_BOUND;
    }


    /*
     * When created with no bound parameter, default is 4.
     */
    public CarMoveStrategy(Random random, int bound) {
        this.random = random;
        this.bound = bound;
    }

    public int getResult() {
        return random.nextInt(bound);
    }
}
