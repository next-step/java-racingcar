package car_racing2.domain;

import java.util.Random;
import java.util.function.BooleanSupplier;

public class RandomMovingStrategy implements MovingStrategy {
    private static final Random random = new Random();
    private static final int MOVE_THRESHOLD = 4;

    private final BooleanSupplier randomMovingSupplier = () -> random.nextInt() > MOVE_THRESHOLD;

    @Override
    public boolean isMovable() {
        return randomMovingSupplier.getAsBoolean();
    }
}
