package carRacing.common;

import java.util.Random;

public class RandomGeneratorImpl implements RandomGenerator{
    private static final Random random = new Random();
    private static final int RANDOM_RANGE = 10;

    protected RandomGeneratorImpl(){}

    public static RandomGeneratorImpl of(){
        return new RandomGeneratorImpl();
    }

    @Override
    public int generate() {
        return random.nextInt(RANDOM_RANGE);
    }
}
