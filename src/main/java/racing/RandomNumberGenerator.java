package racing;

import java.util.Random;

public class RandomNumberGenerator {

    private Random random;

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    public int generate() {
        return random.nextInt(10);
    }
}
