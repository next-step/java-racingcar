package study.step3;

import java.util.Random;

public class RacingRandomGenerator implements RandomGenerator{
    private final static int INIT_RANDOM_NUMBER = 10;

    private Random random;

    public RacingRandomGenerator(){
        random = new Random();
    }

    @Override
    public int getRandomInt() {
        return random.nextInt(INIT_RANDOM_NUMBER);
    }

}
