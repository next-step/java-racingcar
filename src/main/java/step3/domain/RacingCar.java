package step3.domain;

import java.util.Random;

public class RacingCar {
    private static final Random RANDOM = new Random(System.currentTimeMillis());
    private static final int RANDOM_BOUND = 10;
    private static final int MINIMUM_MOVABLE_VALUE = 4;

    private final int id;

    public RacingCar(final int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isMovable() {
        final int randomValue = RANDOM.nextInt(RANDOM_BOUND);
        return randomValue >= MINIMUM_MOVABLE_VALUE;
    }
}
