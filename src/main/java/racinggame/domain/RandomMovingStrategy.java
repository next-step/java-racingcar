package racinggame.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy{
    public static final int FORWARD_CONDITION_NUMBER = 4;
    public static final int MAX_BOUND = 10;

    @Override
    public boolean isMoving() {
        return getRandomNumber() >= FORWARD_CONDITION_NUMBER;
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }
}
