package step3.service;

import java.util.Random;

public class RandomMoving implements Moving {
    private final static int MOVING_DISTANCE = 1;
    private final static int MOVABLE_CRITERIA_LOWER_BOUND = 4;
    private final Random random = new Random();

    @Override
    public boolean movable() {
        return randomNumber() >= MOVABLE_CRITERIA_LOWER_BOUND;
    }

    private int randomNumber() {
        return random.nextInt(10);
    }

}
