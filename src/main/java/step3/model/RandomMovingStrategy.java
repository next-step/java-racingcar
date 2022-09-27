package step3.model;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy
{
    private final Random random = new Random();
    private static final int RANGE = 10;
    private static final int RESTRICTION = 4;

    @Override
    public boolean movable()
    {
        return random.nextInt(RANGE) >= RESTRICTION;
    }
}
