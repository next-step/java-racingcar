package step3;

import java.util.Random;

public class RandomGenerator {
    private final int RANDOM_RANGE = 10;
    private final Random random = new Random();

    public int getRandomNumber(){
        return random.nextInt(RANDOM_RANGE);
    }
}