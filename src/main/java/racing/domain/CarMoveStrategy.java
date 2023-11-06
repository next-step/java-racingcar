package racing.domain;

import java.util.Random;

public class CarMoveStrategy {
    private final Random random;

    public CarMoveStrategy(Random random) {
        this.random = random;
    }

    public int getResult(int bound) {
        return random.nextInt(bound);
    }

}
