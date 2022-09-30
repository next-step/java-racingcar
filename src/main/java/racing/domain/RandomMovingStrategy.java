package racing.domain;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomMovingStrategy implements MovingStrategy
{
    private final Random random = ThreadLocalRandom.current();
    private static final int RANGE = 10;
    private static final int RESTRICTION = 4;

    @Override
    public boolean movable()
    {
        return random.nextInt(RANGE) >= RESTRICTION;
    }
}
