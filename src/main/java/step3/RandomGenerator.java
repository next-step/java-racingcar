package step3;

import java.util.Random;

public class RandomGenerator {

    Random random;

    public RandomGenerator() {
        this.random = new Random();
    }

    public int generate() {
        return random.nextInt(10);
    }
}
