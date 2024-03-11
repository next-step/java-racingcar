package racing.model;

import java.util.Random;

public class RandomMovementStrategy implements CarMovementStrategy {
    private static final int BOUNDARY_NUMBER = 4;
    private static final int BOUNDARY = 10;

    @Override
    public boolean movable() {
        return new Random().nextInt(BOUNDARY) >= BOUNDARY_NUMBER;
    }
}
