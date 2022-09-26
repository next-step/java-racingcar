package step3.model;

import java.util.Random;

public class RandomMove implements Move
{
    private final Random random = new Random();
    private static final int MAX = 10;

    @Override
    public boolean move()
    {
        return random.nextInt(MAX) >= 4;
    }
}
