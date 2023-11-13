package racing.domain;

import java.util.Random;

public class CarMoveStrategy {
    private static final int RANDOM_BOUND = 10;
    private final Random random;
    private final int bound;

    public CarMoveStrategy() {
        this.random = new Random();
        this.bound = RANDOM_BOUND;
    }


    /*
     * When created with no bound parameter, default is 10.
     */
    public CarMoveStrategy(int bound) {
        this.random = new Random();
        this.bound = bound;
    }

    public int getMoveSource() {
        return random.nextInt(bound);
    }
}
