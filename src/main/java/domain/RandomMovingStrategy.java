package domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int FORWARD_THRESHOLD = 4;
    private static final Random random = new Random();

    public static int getRandomNumber() {
        return random.nextInt(10);
    }

    public boolean movable() {
        return getRandomNumber() >= FORWARD_THRESHOLD;
    }
}
