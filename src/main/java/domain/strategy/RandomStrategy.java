package domain.strategy;

import java.util.Random;

public class RandomStrategy implements MovingStrategy {

    private static final Random random = new Random();
    private static final int FORWARD_CONDITION = 4;

    @Override
    public boolean movable() {
        return random.nextInt(10) >= FORWARD_CONDITION;
    }
}
