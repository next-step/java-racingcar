package RacingCar;

import java.util.Random;

public class RandomMovementCondition implements MovementCondition {
    RandomMovementCondition(int moveThreshold) {
        this.moveThreshold = moveThreshold;
    }

    @Override
    public boolean isMovable() {
        if (random.nextInt(MAX_NUMBER) < moveThreshold) {
            return false;
        }
        return true;
    }

    private Random random = new Random();
    private int moveThreshold;
    private final int MAX_NUMBER = 10;
}
