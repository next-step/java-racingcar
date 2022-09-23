package domain.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int OVER_FOUR = 4;
    private static final int BOUND_TEM = 10;
    private static final Random random = new Random();

    @Override
    public boolean movable() {

        return randomNumber() >= OVER_FOUR;
    }

    private int randomNumber() {

        return random.nextInt(BOUND_TEM);
    }
}
