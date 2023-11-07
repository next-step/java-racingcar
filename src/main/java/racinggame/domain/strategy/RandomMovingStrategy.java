package racinggame.domain.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy{

    public static final int MIN_MOVABLE_NUMBER = 3;
    public static final int DEFAULT_BOUND = 10;
    private Random random = new Random();

    @Override
    public boolean movable() {
        return random.nextInt(DEFAULT_BOUND) > MIN_MOVABLE_NUMBER;
    }

}
