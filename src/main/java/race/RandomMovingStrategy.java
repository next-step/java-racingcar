package race;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int BOUND = 10;
    private static final int FORWARD_POSSIBLE_NUMBER = 4;
    private static final Random randomNumberGenerator = new Random();

    @Override
    public boolean isMovable() {
        return randomNumberGenerator.nextInt(BOUND) >= FORWARD_POSSIBLE_NUMBER;
    }
}
