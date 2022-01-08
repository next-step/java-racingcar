package domain;

import java.util.Random;

public class RandomNumberMovingStrategy implements MovingStrategy {
    private Random random;
    private final int randomNumber;
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int CAR_MOVE_CONDITION = 4;

    public RandomNumberMovingStrategy() {
        this.random = new Random();
        this.randomNumber = random.nextInt(RANDOM_NUMBER_BOUND);
    }

    @Override
    public boolean isMovable() {
        return randomNumber >= CAR_MOVE_CONDITION;
    }
}
