package RacingCar.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final Random random = new Random();

    public int moveable(int range) {
        return random.nextInt(range);
    }
}
