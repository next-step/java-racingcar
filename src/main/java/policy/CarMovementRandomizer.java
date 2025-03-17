package policy;

import java.util.Random;

public class CarMovementRandomizer implements CarMovementPolicy {

    private static final int REFERENCE_VALUE = 4;
    private static final int RANDOM_BOUND = 10;

    @Override
    public boolean isMovable() {
        return getRandom() >= REFERENCE_VALUE;
    }

    public static int getRandom() {
        return new Random().nextInt(CarMovementRandomizer.RANDOM_BOUND);
    }
}
