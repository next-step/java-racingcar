package racing.model;

import static racing.util.RandomNumberGeneratorUtil.randomNumber;

public class RandomMovement implements CarMovementStrategy {
    private static final int BOUNDARY_NUMBER = 4;

    @Override
    public boolean movable() {
        return randomNumber() >= BOUNDARY_NUMBER;
    }
}
