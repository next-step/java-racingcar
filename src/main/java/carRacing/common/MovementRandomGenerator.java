package carRacing.common;

import java.util.Random;

public class MovementRandomGenerator implements RandomGenerator{
    private static final Random random = new Random();
    private static final int RANDOM_RANGE = 10;

    protected MovementRandomGenerator(){}

    public static MovementRandomGenerator of(){
        return new MovementRandomGenerator();
    }

    @Override
    public int generate() {
        return random.nextInt(RANDOM_RANGE);
    }
}
