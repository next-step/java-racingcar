package racinggame.domain.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy{

    public static final int MIN_MOVABLE_NUMBER = 3;
    public static final int DEFAULT_BOUND = 10;
    private final Random random = new Random();

    @Override
    public boolean movable() {
        int randomNumber = random.nextInt(DEFAULT_BOUND);
        return randomNumber > MIN_MOVABLE_NUMBER;
    }

}
