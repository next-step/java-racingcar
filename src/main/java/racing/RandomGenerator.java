package racing;

import java.util.Random;

public class RandomGenerator {
    private Random random;
    private final int BOUND = 10;

    public RandomGenerator() {
        random = new Random();
    }

    public int create() {
        return random.nextInt(BOUND);
    }


}
